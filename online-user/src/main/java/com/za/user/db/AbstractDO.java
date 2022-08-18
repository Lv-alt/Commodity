package com.za.user.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lvweichen
 * @date 2022/8/17 5:23 下午
 */
@Getter
@Setter
public class AbstractDO {

    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;
    
    private Integer delState;
    
}
