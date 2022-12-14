package com.za.user.service;

import com.za.user.request.OnlineUserRequest;
import com.za.user.response.OnlineUserLoginResponse;
import com.za.user.response.ResponseDTO;

/**
 * onlien user
 * @author lvweichen
 * @date 2022/8/17 5:31 δΈε
 */
public interface OnlineUserService {

    /**
     * save
     * @param request requset
     * @return result
     */
    ResponseDTO<Boolean> saveUser(OnlineUserRequest request);

    /**
     * η»ι
     * @param request request
     * @return data
     */
    ResponseDTO<OnlineUserLoginResponse> login(OnlineUserRequest request);
    
    

}
