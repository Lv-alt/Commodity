package com.za.user.controller;

import com.za.user.request.OnlineUserRequest;
import com.za.user.response.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * user api
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午3:28
 */
@RequestMapping("/api/user")
public interface OnlineUserControllerApi {

    /**
     * save user
     * @param userRequest user
     * @return result
     */
    @PostMapping("/saveUser")
    ResponseDTO saveUser(@RequestBody OnlineUserRequest userRequest);
    
}
