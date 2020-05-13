package com.kaizhuo.common.core.config.db;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.config
 * @description:
 * @author: miaochen
 * @create: 2020-05-13 22:40
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    private static final Logger log = LoggerFactory.getLogger(MybatisMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        //版本号3.0.6以及之前的版本
        this.setFieldValByName("create_time", new Date(), metaObject);
        this.setFieldValByName("update_time", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        //版本号3.0.6以及之前的版本
        this.setFieldValByName("update_time", new Date(), metaObject);
    }
}
