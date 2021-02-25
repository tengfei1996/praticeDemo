package com.example.demo.base.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author ntf
 * @version 1.0
 * @date 2021/2/5 11:52
 * @description
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("modifyDate",LocalDateTime.now(),metaObject);
        this.setFieldValByName("createDate", LocalDateTime.now(),metaObject);
        this.setFieldValByName("describtion","这人很懒，什么都没留下。。。",metaObject);
    }

    /**
     * 修改时自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifyDate",LocalDateTime.now(),metaObject);
    }
}
