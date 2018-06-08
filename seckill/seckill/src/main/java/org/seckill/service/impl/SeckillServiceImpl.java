package org.seckill.service.impl;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;

import java.util.List;

/**
 * @program: seckill
 * @description: 秒杀接口实现
 * @author: rayzxh
 * @create: 2018-06-08 17:02
 **/
public class SeckillServiceImpl implements SeckillService {
    @Override
    public List<Seckill> getSecKillList() {

        return null;
    }

    @Override
    public Seckill getById(long seckillId) {
        return null;
    }

    @Override
    public Exposer exportSeckillURL(long seckillId) {
        return null;
    }

    @Override
    public SeckillExcution excuteSeckill(long seckillId, long userPhone, String md5) throws SeckillException {
        return null;
    }
}
