package com.za.user.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author lvweichen
 * @date 2022/8/17 5:37 下午
 */
@Data
public class OnlineUserRequest {
    
    @NotNull
    private String account;

    @NotNull
    private String passWord;

}
