package org.seckill.exception;

/**
 * @program: seckill
 * @description: 秒杀关闭异常
 * @author: rayzxh
 * @create: 2018-06-08 16:50
 **/
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
