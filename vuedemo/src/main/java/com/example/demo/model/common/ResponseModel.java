package com.example.demo.model.common;


import com.example.demo.base.baseEnum.BaseEnum;

/**
 * 数据请求响应结果定义
 */
public class ResponseModel {
    //状态码
    private Integer code;
    //状态
    private Boolean success;
    //消息
    private String message;
    //数据对象
    private Object data;
    public ResponseModel() {
        this.success = true;
        this.code = BaseEnum.ResponseStatus.SUCCESS.getCode();
        this.message = BaseEnum.ResponseStatus.SUCCESS.getMessage();
    }
    /**
     * 只返回状态，状态码，消息
     *
     * @param
     * @param code
     * @param message
     */
    public ResponseModel(Boolean success, Integer code, String message) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 当只输入返回值时 默认success=true
     *
     * @param data
     */
    public ResponseModel(Object data) {
        super();
        this.success = true;
        this.code = BaseEnum.ResponseStatus.SUCCESS.getCode();
        this.message = BaseEnum.ResponseStatus.SUCCESS.getMessage();
        this.data=data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
