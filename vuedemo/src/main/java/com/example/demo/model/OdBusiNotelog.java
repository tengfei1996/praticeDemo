package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 消息记录表 
 * </p>
 *
 * @author ningtf
 * @since 2021-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("od_busi_notelog")
public class OdBusiNotelog extends Model<OdBusiNotelog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 主键标识
     */
    private Long id;

    /**
     * 数据类别 留言类别
     */
    private String noteType;

    /**
     * 关联id 关联业务id，针对流程中的留言，关联流程配置主键
     */
    private String relationId;

    /**
     * 留言内容 留言内容
     */
    private String note;

//    @Version
    private Integer version;

    /**
     * 操作人姓名 操作人姓名
     */
    private String userName;

    /**
     * 操作时间 操作时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDate;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
