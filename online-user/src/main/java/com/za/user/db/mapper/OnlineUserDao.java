package com.za.user.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.za.user.db.dataobject.OnlineUserDO;
import org.springframework.stereotype.Component;


/**
 * @author lvweichen
 * @date 2022/8/17 5:27 下午
 */
@Component
public interface OnlineUserDao extends BaseMapper<OnlineUserDO> {
}
