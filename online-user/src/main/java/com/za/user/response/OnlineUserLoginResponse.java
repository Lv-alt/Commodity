package com.za.user.response;

import lombok.Data;

import java.util.List;

/**
 * 登陆成功返回
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午3:08
 */
@Data
public class OnlineUserLoginResponse {
    
    private String account;
    
    private String token;
    
    private List<String> source;
    
}
