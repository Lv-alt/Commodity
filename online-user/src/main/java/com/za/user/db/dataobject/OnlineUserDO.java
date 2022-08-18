package com.za.user.db.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lvweichen
 * @date 2022/8/17 5:22 下午
 */
@Data
@TableName("online_user")
public class OnlineUserDO extends AbstractDO {

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 用户状态1，正常。2 冻结
     */
    private Integer state = 1;

    /**
     * 角色
     */
    private Integer roleId;

}
