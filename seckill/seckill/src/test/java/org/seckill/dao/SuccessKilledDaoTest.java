package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() {
        long id = 1000L;
        long phone = 13305757776L;
        int count = successKilledDao.insertSuccessKilled(id,phone);

    }

    @Test
    public void queryByIdWithSecKill() {
        long id = 1000L;
        long phone = 13305757776L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSecKill(id,phone);
        System.out.println(successKilled.getSeckill());
    }
}