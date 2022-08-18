package com.za.user.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午5:16
 */
@Component
public class MybatisConfig implements MetaObjectHandler {
    
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("created", "system", metaObject);    
        this.setFieldValByName("delState", 1, metaObject);    
        this.setFieldValByName("createDate", new Date(), metaObject);
        this.setFieldValByName("updated", "system", metaObject);
        this.setFieldValByName("updateDate", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updated", "system", metaObject);
        this.setFieldValByName("updateDate", new Date(), metaObject);
    }
}
