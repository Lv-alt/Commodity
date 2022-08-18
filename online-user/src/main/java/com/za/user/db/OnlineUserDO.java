package com.za.user.db;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lvweichen
 * @date 2022/8/17 5:22 下午
 */
@Data
@TableName("online_user")
public class OnlineUserDO extends AbstractDO {

    private String account;

    private String passWord;

    private Integer state;

}
