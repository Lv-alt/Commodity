package com.za.user.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvweichen πΊ β β β β¦β¦ οΈπ
 * @date 2022/8/19 δΈε10:44
 */
@Configuration
public class MybatisConfiguration {
    
    @Bean
    public ISqlInjector sqlInjector() {
        //ζ³¨ει»θΎε ι€η»δ»Ά
        return new LogicSqlInjector();
    }
    
}
