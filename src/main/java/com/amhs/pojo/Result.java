package com.amhs.pojo;

/**
 * @author Sun.chuanwang
 * @version 1.0.0
 * @date 2020/12/19 10:33
 */
public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private Object item;

    public Result(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Result(Boolean success, Integer code, String message,Object item) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.item = item;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
