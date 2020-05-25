package com.kaizhuo.tiangong.boot.common.constants;

/**
 * Created by Administrator on 2018/3/3.
 */
public class Constants {
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

    // 可用状态标识位
    public static final String ENABLE_YES = "1";    //可用
    public static final String ENABLE_NO = "0";     //不可用

    /**
     * 当前页码
     */
    public static final String PAGE = "page";
    /**
     * 每页显示记录数
     */
    public static final String LIMIT = "limit";
    /**
     * 排序字段
     */
    public static final String ORDER_FIELD = "sidx";
    /**
     * 排序方式
     */
    public static final String ORDER = "order";
    /**
     *  升序
     */
    public static final String ASC = "asc";

}
