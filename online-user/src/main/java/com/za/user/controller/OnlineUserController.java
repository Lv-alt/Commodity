package com.za.user.controller;

import com.za.user.db.OnlineUserDO;
import com.za.user.request.OnlineUserRequest;
import com.za.user.response.ResponseDTO;
import com.za.user.service.OnlineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvweichen
 * @date 2022/8/17 6:01 下午
 */
@RestController
@RequestMapping("/api/user")
public class OnlineUserController {

    @Autowired
    private OnlineUserService userService;

    @PostMapping("/saveUser")
    public ResponseDTO saveUser(@RequestBody OnlineUserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

}
