package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

public interface SeckillService {
    /*
    * @Description:  查询所有秒杀记录
    * @params:[] 
    * @return: List<Seckill> 
    * @Author: rayzxh 
    * @Date: 2018/6/8 
    */ 
    List<Seckill> getSecKillList();
    /*
    * @Description:根据id查询秒杀记录 
    * @params:[seckillId] 
    * @return: org.seckill.entity.Seckill 
    * @Author: rayzxh 
    * @Date: 2018/6/8 
    */ 
    Seckill getById(long seckillId);
    
    /*
    * @Description:  秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
    * @params:[seckillId] 
    * @return: Exposer
    * @Author: rayzxh 
    * @Date: 2018/6/8 
    */ 
    Exposer exportSeckillURL(long seckillId);

    
    /* 
    * @Description: 执行秒杀操作
    * @params:[seckillId, userPhone, md5] 
    * @return: org.seckill.dto.SeckillExcution 
    * @Author: rayzxh 
    * @Date: 2018/6/8 
    */ 
    SeckillExcution excuteSeckill(long seckillId, long userPhone, String md5) throws SeckillException,SeckillCloseException,RepeatKillException;
}
