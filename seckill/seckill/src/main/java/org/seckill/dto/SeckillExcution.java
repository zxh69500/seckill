package org.seckill.dto;

import org.seckill.entity.SuccessKilled;

/**
 * @program: seckill
 * @description:封装秒杀执行后的结果
 * @author: rayzxh
 * @create: 2018-06-08 16:42
 **/
public class SeckillExcution {
    private long seckillId;
    //秒杀执行结果
    private int state;

    //状态说明
    private String stateInfo;
    //秒杀成功对象
    private SuccessKilled successKilled;

    public SeckillExcution(long seckillId, int state, String stateInfo, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.successKilled = successKilled;
    }

    public SeckillExcution(long seckillId, int state, String stateInfo) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
