package com.za.user.enums;


/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 上午10:19
 */
public enum ErrorEnum {

    DEFAULT_ERROR("500","系统异常"),
    LOGIN("001","用户名或密码异常"),
    LOGIN_AUTH("002","权限不足");
    
    ErrorEnum(String code,String message) {
        this.code = code;
        this.message = message;
    }
    
    private String code;
    
    private String message;
    
    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
    
}
