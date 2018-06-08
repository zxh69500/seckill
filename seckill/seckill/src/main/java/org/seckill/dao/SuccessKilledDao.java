package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;

/**
 * @program: seckill
 * @description:
 * @author: rayzxh
 * @create: 2018-06-07 10:38
 **/
public interface SuccessKilledDao {
    /*
    * @Description: 插入秒杀明细可过滤重复
    * @params:[successKilledId, userPhone]
    * @return: int
    * @Author: rayzxh
    * @Date: 2018/6/7
    */
    int insertSuccessKilled(@Param("successKilledId") long successKilledId, @Param("userPhone") long userPhone);
    
    /*  
    * @Description: 根据seckillid查询秒杀订单
    * @params:[seckill] 
    * @return: org.seckill.entity.SuccessKilled 
    * @Author: rayzxh 
    * @Date: 2018/6/7 
    */ 
    SuccessKilled queryByIdWithSecKill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
