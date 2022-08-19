package com.za.user.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.za.user.db.dataobject.OnlineSourceUrlDO;
import com.za.user.db.dataobject.OnlineUserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午2:11
 */
@Component
public interface OnlineSourceUrlDao extends BaseMapper<OnlineSourceUrlDO> {

    /**
     * 如果是自己编写的mapper文件，一定要在sql语句中加上逻辑删除的条件,自己编写的mapper mybatis-plus
     * 不会自动编写上逻辑删除的条件
     * 根据用户查询对应的权限
     * @param userDO userdo
     * @return data
     */
    List<OnlineSourceUrlDO> selectSourceUrlByUser(@Param("user") OnlineUserDO userDO); 
    
}
