package com.za.user.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/19 下午2:44
 */
@Data
public class OnlineUserDTO {

    private String account;

    private String token;

    private List<String> source;
    
}

