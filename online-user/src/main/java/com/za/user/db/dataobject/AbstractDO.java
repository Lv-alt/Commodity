package com.za.user.db.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
    
    @TableField(fill = FieldFill.INSERT)
    private Integer delState;

    @TableField(fill = FieldFill.INSERT)
    private String created;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updated;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
    
}
