package com.za.user.db.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
    
    private String created;
    
    private Date createDate;
    
    private String updated;
    
    private Date updateDate;
    
}
