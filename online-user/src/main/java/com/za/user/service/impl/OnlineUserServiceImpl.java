package com.za.user.service.impl;

import com.za.user.convert.OnlineUserConvert;
import com.za.user.db.OnlineUserDO;
import com.za.user.mapper.OnlineUserDao;
import com.za.user.request.OnlineUserRequest;
import com.za.user.response.ResponseDTO;
import com.za.user.service.OnlineUserService;
import com.za.user.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lvweichen
 * @date 2022/8/17 5:39 下午
 */
@Service
public class OnlineUserServiceImpl implements OnlineUserService {

    @Autowired
    private OnlineUserDao userDao;

    @Override
    public ResponseDTO<Boolean> saveUser(OnlineUserRequest request) {
        OnlineUserDO onlineUserDO = OnlineUserConvert.CONVERT.requestConvertDO(request);
        userDao.insert(onlineUserDO);
        return ResponseUtil.success(true);
    }
}
