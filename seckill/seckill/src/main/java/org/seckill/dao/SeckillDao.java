package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @program: seckill
 * @description:
 * @author: rayzxh
 * @create: 2018-06-07 10:18
 **/
public interface SeckillDao {
    /*
    * @Description: 减少库存
    * @params:[seckillId, killTime] 
    * @return: int 
    * @Author: rayzxh 
    * @Date: 2018/6/7 
    */ 
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
    /*  
    * @Description: 根据id查询秒杀商品
    * @params:[seckillId] 
    * @return: org.seckill.entity.Seckill 
    * @Author: rayzxh 
    * @Date: 2018/6/7 
    */ 
    Seckill queryById(long seckillId);
    /*
    * @Description: 根据偏移量查询秒杀商品列表 
    * @params:[offset, limit] 
    * @return: java.util.List<org.seckill.entity.Seckill> 
    * @Author: rayzxh 
    * @Date: 2018/6/7 
    */
    //通过形参注解来告诉mybaits这个参数是什么
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
    

}
