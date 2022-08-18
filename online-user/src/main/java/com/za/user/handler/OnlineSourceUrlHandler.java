package com.za.user.handler;

import com.za.user.db.dataobject.OnlineSourceUrlDO;
import com.za.user.db.dataobject.OnlineUserDO;

import java.util.List;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午2:36
 */
public interface OnlineSourceUrlHandler {

    /**
     * 根据用户查询对应的权限
     * @param userDO userdo
     * @return data
     */
    List<OnlineSourceUrlDO> selectSourceUrlByUser(OnlineUserDO userDO);

}
