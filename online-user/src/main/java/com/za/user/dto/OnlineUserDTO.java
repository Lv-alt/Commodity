package com.za.user.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lvweichen πΊ β β β β¦β¦ οΈπ
 * @date 2022/8/19 δΈε2:44
 */
@Data
public class OnlineUserDTO {

    private String account;

    private String token;

    private List<String> source;
    
}

