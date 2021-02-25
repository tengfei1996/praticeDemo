package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *     用户信息表
 * </p>
 *
 * @author ningtf
 * @since 2021-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("system_user")
public class SystemUser extends Model<SystemUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键id
     */
    @TableId("id")
    private Long id;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String password;

    /**
     * 描述
     */
    @TableField(fill = FieldFill.INSERT)
    private String describtion;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 修改日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDate;

    /**
     * 版本/乐观锁
     */
//    @Version
    private Integer version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
