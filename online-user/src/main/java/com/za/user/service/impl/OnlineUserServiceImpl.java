package com.za.user.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.za.user.convert.OnlineUserConvert;
import com.za.user.db.dataobject.OnlineSourceUrlDO;
import com.za.user.db.dataobject.OnlineUserDO;
import com.za.user.db.mapper.OnlineUserDao;
import com.za.user.enums.ErrorEnum;
import com.za.user.handler.OnlineSourceUrlHandler;
import com.za.user.request.OnlineUserRequest;
import com.za.user.response.OnlineUserLoginResponse;
import com.za.user.response.ResponseDTO;
import com.za.user.service.OnlineUserService;
import com.za.user.util.RedisUtil;
import com.za.user.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lvweichen
 * @date 2022/8/17 5:39 下午
 */
@Service
public class OnlineUserServiceImpl implements OnlineUserService {

    @Autowired
    private OnlineUserDao userDao;
    @Autowired
    private OnlineSourceUrlHandler sourceUrlHandler;
    @Autowired
    private RedisUtil<String> redisUtil;
    
    @Override
    public ResponseDTO<Boolean> saveUser(OnlineUserRequest request) {
        OnlineUserDO onlineUserDO = OnlineUserConvert.CONVERT.requestConvertDO(request);
        //密码加密
        onlineUserDO.setPassWord(Base64Encoder.encode(onlineUserDO.getPassWord()));
        userDao.insert(onlineUserDO);
        return ResponseUtil.success(true);
    }

    @Override
    public ResponseDTO<OnlineUserLoginResponse> login(OnlineUserRequest request) {
        String encodePassword = Base64.encode(request.getPassWord());
        OnlineUserDO userDO = userDao.selectOne(Wrappers.<OnlineUserDO>lambdaQuery().eq(OnlineUserDO::getAccount, request.getAccount()).eq(OnlineUserDO::getPassWord, encodePassword));
        if(ObjectUtil.isEmpty(userDO)) {
            return ResponseUtil.fail(ErrorEnum.LOGIN.getMessage(),ErrorEnum.LOGIN.getCode());     
        }
        //登陆成功查询权限
        List<OnlineSourceUrlDO> sourceUrlList = sourceUrlHandler.selectSourceUrlByUser(userDO);
        String token = UUID.randomUUID().toString().replace("-","");
        OnlineUserLoginResponse result = builderLoginResponse(userDO, sourceUrlList, token);
        //存缓存
        String resultJSONString = JSONObject.toJSONString(result);
        redisUtil.setCache(token,resultJSONString);
        return ResponseUtil.success(result);
    }

    /**
     * 构建返回
     * @param userDO user
     * @param sourceUrlDOList source
     * @return result
     */
    private OnlineUserLoginResponse builderLoginResponse(OnlineUserDO userDO, List<OnlineSourceUrlDO> sourceUrlDOList, String token) {
        OnlineUserLoginResponse loginResponse = new OnlineUserLoginResponse();
        loginResponse.setAccount(userDO.getAccount());
        loginResponse.setToken(token);
        List<String> list = Optional.of(sourceUrlDOList.stream().map(OnlineSourceUrlDO::getSource).collect(Collectors.toList())).orElse(Collections.emptyList());
        loginResponse.setSource(list);
        return loginResponse;
    }
}
