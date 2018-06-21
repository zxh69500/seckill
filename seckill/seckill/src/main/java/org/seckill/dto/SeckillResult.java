package org.seckill.dto;

/**
 * @program: seckill
 * @description:
 * @author: rayzxh
 * @create: 2018-06-15 14:09
 **/
public class SeckillResult<T> {

    private Boolean success;

    private T data;

    private String error;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public SeckillResult(Boolean success, String error) {

        this.success = success;
        this.error = error;
    }

    public SeckillResult(Boolean success, T data) {

        this.success = success;
        this.data = data;
    }
}
