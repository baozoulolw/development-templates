package com.baozoulolw.wlog.common.publicfields;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础entity，无ID的表继承该类
 *
 * @author Baozoulolw
 * @date 2021年1月18日11:56:13
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 最后操作人
     */
    @TableField(value = "last_operator",fill = FieldFill.INSERT_UPDATE)
    private Long lastOperator;

    /**
     * 创建人
     */
    @TableField(value = "founder",fill = FieldFill.INSERT)
    private Long founder;

    /**
     * 最后操作时间，本条记录的新增、修改动作，即更新本时间戳
     */
    @TableField(value = "change_time",fill = FieldFill.INSERT_UPDATE,jdbcType=JdbcType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date changeTime;

    /**
     * 记录创建时间，即本条记录的新增时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT,jdbcType=JdbcType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
}
