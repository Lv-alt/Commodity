package com.za.user.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author lvweichen πΊ β β β β¦β¦ οΈπ
 * @date 2022/8/19 δΈε3:19
 */
@ConfigurationProperties("za.user.not-filter-url")
@Configuration
@Getter
@Setter
public class OnlineUserProperties {
    
    private List<Map<String, String>> list;
    
}
