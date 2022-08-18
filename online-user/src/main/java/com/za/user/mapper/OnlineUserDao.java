package com.za.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.za.user.db.OnlineUserDO;
import org.springframework.stereotype.Component;


/**
 * @author lvweichen
 * @date 2022/8/17 5:27 下午
 */
@Component
public interface OnlineUserDao extends BaseMapper<OnlineUserDO> {
}
