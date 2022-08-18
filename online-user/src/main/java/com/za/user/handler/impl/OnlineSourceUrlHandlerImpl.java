package com.za.user.handler.impl;

import com.za.user.db.dataobject.OnlineSourceUrlDO;
import com.za.user.db.dataobject.OnlineUserDO;
import com.za.user.db.mapper.OnlineSourceUrlDao;
import com.za.user.handler.OnlineSourceUrlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午2:38
 */
@Component
public class OnlineSourceUrlHandlerImpl implements OnlineSourceUrlHandler {
    
    @Autowired
    private OnlineSourceUrlDao sourceUrlDao;
    
    @Override
    public List<OnlineSourceUrlDO> selectSourceUrlByUser(OnlineUserDO userDO) {
        return sourceUrlDao.selectSourceUrlByUser(userDO);
    }
}
