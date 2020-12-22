package com.amhs.pojo;

/**
 * @author Sun.chuanwang
 * @version 1.0.0
 * @date 2020/12/19 10:39
 */
public enum ResultCode {

    SUCCESS(true,10000,"操作成功"),
    FAULT(false,10001,"请求失败");


    Boolean success;
    Integer code;
    String message;

    ResultCode(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean success(){
        return success;
    }

    public Integer code(){
        return code;
    }

    public String message(){
        return message;
    }
}
