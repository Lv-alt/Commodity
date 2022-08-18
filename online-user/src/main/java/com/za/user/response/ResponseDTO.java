package com.za.user.response;

import lombok.Data;

/**
 * @author lvweichen
 * @date 2022/8/17 5:32 下午
 */
@Data
public class ResponseDTO<T> {

    private String code;

    private String message;

    private T data;

    public void success(T data) {
        this.code = "200";
        this.message = "success";
        this.data = data;
    }

    public void fail(String message) {
        this.code = "500";
        this.message = message;
    }

}
