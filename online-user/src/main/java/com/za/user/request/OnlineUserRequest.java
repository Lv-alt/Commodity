package com.za.user.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author lvweichen
 * @date 2022/8/17 5:37 下午
 */
@Data
@NoArgsConstructor
public class OnlineUserRequest {
    
    @NotNull
    private String account;

    @NotNull
    private String passWord;
    
    @Max(10)
    private Integer roleId;

}
