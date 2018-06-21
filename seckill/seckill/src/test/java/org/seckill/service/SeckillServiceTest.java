package org.seckill.service;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})

public class SeckillServiceTest {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;
    @Test
    public void getSecKillList() {
        List<Seckill> list = seckillService.getSecKillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckilll = {}",seckill);
    }

    @Test
    public void exportSeckillURL() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillURL(id);
        logger.info("exposer ={}",exposer);
    }


    @Test
    public void excuteSeckill() {
        long id = 1000;
        long phone = 13392929292l;
        String md5 = "56454454546";
        try {
            SeckillExcution seckillExcution = seckillService.excuteSeckill(id,phone,md5);
            logger.info("excution={}",seckillExcution);

        }catch (RepeatKillException e){
            logger.error(e.getMessage());
        }catch (SeckillCloseException e){

        }
    }
}