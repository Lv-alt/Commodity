package com.za.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/za/user/mapper")
public class OnlineUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineUserApplication.class, args);
    }

}
