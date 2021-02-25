package com.example.demo.base.baseEnum;

/**
 * 通用枚举定义
 */
public class BaseEnum {

    /**
     * 数据响应枚举定义
     */
    public enum ResponseStatus {
        SUCCESS(200, "请求成功"),
        USERNAME_OR_PASSWORD_ERROR(-1001, "用户名或密码错误"),
        USER_NOT_FOUND(-1002, "用户不存在"),
        USER_NOT_LOGIN(-1003, "用户未登录"),
        //参数格式错误
        VALID_EXCEPTION(400, "参数格式错误"),
        //Token
        TOKEN_EMPTY(401, "Token不能为空"),
        Data_EMPTY(401, "数据不存在或已删除"),
        TOKEN_TIME_OUT(403, "Token过时"),
        //服务器异常
        SERVER_EXCEPTION(500, "服务器异常"),
        //项目
        OPERATE_FAIL(1005, "操作失败"),

        //关联删除
        DELETE_ASSOCIATE_FAIL(1006, "存在关联信息，请先删除子级"),
        //认证码验证失败
        VERIFYCHECKFALSE(1007, "认证码验证失败"),
        //认证码验证失败
        SQL_ERROR(501, "数据SQL报错"),
        //重复参数
        DUPLICATED_PARAMETERS(409, "重复参数");


        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        /**
         * 返回码
         */
        int code;
        /**
         * 返回结果描述
         */
        String message;

        ResponseStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    /**
     * 加密配置
     */
    public enum SecurityEnum{
        /**
         * 加密种子
         */
        SECSEED(4);
        SecurityEnum(int code){
            this.code = code;
        }
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        private int code;
    }


}
