package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
/*
    配置spring和junit整合,junit启动时加载springIOC容器
    * */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入dao实现依赖
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() {
        Date killdate = new Date();
        int updatecount = seckillDao.reduceNumber(1000L,killdate);
        System.out.println(updatecount);
    }
    /*

     */
    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> list = seckillDao.queryAll(0,10);
        for (Seckill seckill:list
             ) {
            System.out.println(seckill);
        }
    }
}