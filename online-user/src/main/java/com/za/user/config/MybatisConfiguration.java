package com.za.user.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/19 上午10:44
 */
@Configuration
public class MybatisConfiguration {
    
    @Bean
    public ISqlInjector sqlInjector() {
        //注册逻辑删除组件
        return new LogicSqlInjector();
    }
    
}
