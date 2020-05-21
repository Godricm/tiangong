package com.kaizhuo.tiangong.boot.core.enums;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.core.enums
 * @description:
 * @author: miaochen
 * @create: 2020-05-19 23:44
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public enum OpType {
    INSERT("新增"),
    EDIT("编辑"),
    DEL("删除"),
    EXPORT("导出"),
    IMPORT("导入"),
    OTHER("其它"),
    ;

    private String type;

    OpType(String type) {
        this.type = type;
    }
}
