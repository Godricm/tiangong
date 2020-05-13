package com.kaizhuo.common.core.domain.system;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.domain.system
 * @description: 组织结构表
 * @author: miaochen
 * @create: 2020-05-04 14:12
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class Organize {
    /**
     *id
     */
    private Long id;
    /**
     * 组织名称
     */
    private String organizeName;

    private Long parentId;

    private Integer orderNum;

}
