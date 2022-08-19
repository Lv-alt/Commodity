package com.za.user.util;

import com.alibaba.fastjson.JSONObject;
import com.za.user.dto.OnlineUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户工具类
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/19 下午2:37
 */
@Component
public class UserUtil {
    
    @Autowired
    private RedisUtil<String> redisUtil;

    /**
     * 获取用户信息
     */
    public OnlineUserDTO getUserInfo() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //子线程共享request
        RequestContextHolder.setRequestAttributes(servletRequestAttributes, true);
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader(GlobalConstant.TOKEN);
        //查询缓存
        String userInfo = redisUtil.getCache(token);
        OnlineUserDTO userDTO = JSONObject.parseObject(userInfo, OnlineUserDTO.class);
        return userDTO;
    }
    
}
