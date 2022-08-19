package com.za.user.filter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.za.user.config.OnlineUserProperties;
import com.za.user.dto.OnlineUserDTO;
import com.za.user.enums.ErrorEnum;
import com.za.user.util.GlobalConstant;
import com.za.user.util.ResponseUtil;
import com.za.user.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * 登陆认证拦截器
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/19 下午1:41
 */
@Component
public class LoginAuthFilter implements Filter {
    
    @Autowired
    private OnlineUserProperties userProperties;
    
    @Autowired
    private UserUtil userUtil;
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse; 
        String token = request.getHeader(GlobalConstant.TOKEN);
        if (notFilter(request)) {
            //默认放过
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //没有token直接返回
        if (StrUtil.isBlank(token) || !auth(request)) {
            res.setContentType("application/json; charset=UTF-8");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().print(JSONObject.toJSON(
                    ResponseUtil.fail(ErrorEnum.LOGIN_AUTH.getCode(), ErrorEnum.LOGIN_AUTH.getMessage())));
            return;
        }
        //默认放过
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 认证该用户是否有权限访问目标url
     * @param request request
     * @return result
     */
    private boolean auth(HttpServletRequest request) {
        OnlineUserDTO userInfo = userUtil.getUserInfo();
        // 判断是否有权限访问目标url
        for (String item : Optional.of(userInfo.getSource()).orElse(Collections.emptyList())) {
            if (request.getRequestURL().toString().endsWith(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 过滤不用验证的方法
     * @return result
     */
    private boolean notFilter(HttpServletRequest request) {
        for (Map<String, String> hash : Optional.of(userProperties.getList()).orElse(Collections.emptyList())) {
            for (Map.Entry<String, String> entry : hash.entrySet()) {
                if (request.getRequestURL().toString().endsWith(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
