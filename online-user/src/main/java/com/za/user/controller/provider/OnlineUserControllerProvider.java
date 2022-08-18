package com.za.user.controller.provider;

import com.za.user.controller.OnlineUserControllerApi;
import com.za.user.request.OnlineUserRequest;
import com.za.user.response.ResponseDTO;
import com.za.user.service.OnlineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvweichen
 * @date 2022/8/17 6:01 下午
 */
@RestController
public class OnlineUserControllerProvider implements OnlineUserControllerApi {

    @Autowired
    private OnlineUserService userService;

    @Override
    public ResponseDTO saveUser(OnlineUserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

}
