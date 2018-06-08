package org.seckill.exception;

/**
 * @program: seckill
 * @description:
 * @author: rayzxh
 * @create: 2018-06-08 16:51
 **/
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
