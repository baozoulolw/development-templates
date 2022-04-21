package com.baozoulolw.wlog.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baozoulolw.wlog.utils.UserUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 数据据库进行操作时自动增添数据
 *
 * @author Baozoulolw
 * @version 1.0
 * @date 2021-03-13 15:17
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建时间
     */
    private static final String CREATE_TIME = "createTime";

    /**
     * 创建人
     */
    private static final String FOUNDER = "founder";

    /**
     * 更改时间
     */
    private static final String CHANGE_TIME = "changeTime";

    /**
     * 更改人
     */
    private static final String LAST_OPERATOR = "lastOperator";

    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        check(metaObject, CREATE_TIME, FOUNDER);
        updateFill(metaObject);
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        check(metaObject, CHANGE_TIME, LAST_OPERATOR);
    }

    private void check(MetaObject metaObject, String changeTime, String lastOperator) {
        boolean hasUpdate = metaObject.hasSetter(changeTime);
        boolean hasSetter = metaObject.hasSetter(lastOperator);
        if (hasUpdate) {
            Object updateTime = metaObject.getValue(changeTime);
            if (null != updateTime) {
                setFieldValByName(changeTime, updateTime, metaObject);
            } else {
                setFieldValByName(changeTime, new Date(), metaObject);
            }
        }
        if (hasSetter) {
            Object operator = metaObject.getValue(lastOperator);
            if (null != operator) {
                setFieldValByName(lastOperator, operator, metaObject);
            } else {
                setFieldValByName(lastOperator, UserUtils.getUserId(), metaObject);
            }
        }
    }


}
