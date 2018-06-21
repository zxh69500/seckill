package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: seckill
 * @description:
 * @author: rayzxh
 * @create: 2018-06-13 15:41
 **/
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Seckill> list = seckillService.getSecKillList();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model){
        if (seckillId == null) {
            return "redirct:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill",seckill);
        return "detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") long seckillId){
        SeckillResult<Exposer> seckillResult;
        try {
            Exposer exposer = seckillService.exportSeckillURL(seckillId);
            seckillResult = new SeckillResult<Exposer>(true,exposer);

        }catch (Exception e){
            logger.error(e.getMessage());
            seckillResult = new SeckillResult<Exposer>(false,e.getMessage());
        }
        return seckillResult;

    }

    @RequestMapping(value = "/{seckillId}/{md5}/excution",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
    @ResponseBody
    public SeckillResult<SeckillExcution> excute(@PathVariable("seckillId") long seckillId,@PathVariable("md5") String md5,@CookieValue(value = "killPhone",required = false) long userPhone){
        SeckillResult<SeckillExcution> seckillResult;
        try {
            SeckillExcution seckillExcution = seckillService.excuteSeckill(seckillId,userPhone,md5);
            seckillResult = new SeckillResult<SeckillExcution>(true,seckillExcution);

        }catch (SeckillCloseException e){
            SeckillExcution seckillExcution = new SeckillExcution(seckillId,SeckillStateEnum.END);
            seckillResult = new SeckillResult<SeckillExcution>(false,seckillExcution);
        }catch (RepeatKillException e1){
            SeckillExcution seckillExcution = new SeckillExcution(seckillId,SeckillStateEnum.REPEAT_KILL);
            seckillResult = new SeckillResult<SeckillExcution>(false,seckillExcution);
        }catch (Exception e2){
            SeckillExcution seckillExcution = new SeckillExcution(seckillId,SeckillStateEnum.INNER_ERROR);
            seckillResult = new SeckillResult<SeckillExcution>(false,seckillExcution);
        }
        return seckillResult;
    }
    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    public SeckillResult<Long> time(){
        Date date = new Date();
        return new SeckillResult<Long>(true,date.getTime());
    }

}
