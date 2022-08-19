package com.za.user.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.za.user.dto.OnlineUserDTO;
import com.za.user.util.GlobalConstant;
import com.za.user.util.UserUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.za.user.util.GlobalConstant;

import java.util.Date;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午5:16
 */
@Component
public class MybatisConfig implements MetaObjectHandler {

    @Autowired
    private UserUtil userUtil;
    
    @Override
    public void insertFill(MetaObject metaObject) {
        OnlineUserDTO userDTO = userUtil.getUserInfo();
        this.setFieldValByName(GlobalConstant.CREATED, userDTO != null ? userDTO.getAccount() : GlobalConstant.SYSTEM, metaObject);    
        this.setFieldValByName(GlobalConstant.DEL_STATE, 1, metaObject);    
        this.setFieldValByName(GlobalConstant.CREATE_DATE, new Date(), metaObject);
        this.setFieldValByName(GlobalConstant.UPDATED, userDTO != null ? userDTO.getAccount() : GlobalConstant.SYSTEM, metaObject);
        this.setFieldValByName(GlobalConstant.UPDATE_DATE, new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        OnlineUserDTO userDTO = userUtil.getUserInfo();
        this.setFieldValByName(GlobalConstant.UPDATED, userDTO != null ? userDTO.getAccount() : GlobalConstant.SYSTEM, metaObject);
        this.setFieldValByName(GlobalConstant.UPDATE_DATE, new Date(), metaObject);
    }
}
