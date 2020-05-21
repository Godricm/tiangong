package com.kaizhuo.tiangong.boot.core.constants;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.core.constants
 * @description:
 * @author: miaochen
 * @create: 2020-05-20 23:15
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class Constant {
    public static final String ADMIN_NAME = "admin";
    public static final Long ADMIN_ROLE_ID = 1L;
    public static final Long INDEX_ROOT_RESOURCE_ID = 1L;
    public static final Long INDEX_RESOURCE_ID = 2L;
    public static final Long DASHBOARD_RESOURCE_ID = 3L;
    // 默认分页配置
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int DEFAULT_PAGE_NUM = 1;


    // 删除标识位
    public static final Integer DELETE_CODE_NO = 0;
    public static final Integer DELETE_CODE_YES = 1;

    public static final String HEADER_USER_ID = "X-USER-ID";
    public static final String HEADER_SOURCE = "X-SOURCE";

    public static final String AUTHORIZATION = "Authorization";

    public static final String FIELD_CREATE_TIME = "create_time";
    public static final String FIELD_UPDATE_TIME = "update_time";
}