package com.baozoulolw.wlog.common.publicfields;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 *  带id实体类
 *
 * @author Baozoulolw
 * @version 1.0
 * @date 2021-01-18 15:53
 */
@Data
public class IdEntity extends BaseEntity implements Serializable {

    @TableField(value = "id", fill = FieldFill.INSERT)
    private Long id;

}
