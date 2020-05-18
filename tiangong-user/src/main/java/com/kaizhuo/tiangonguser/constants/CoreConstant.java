package com.kaizhuo.tiangonguser.constants;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.constants
 * @description:
 * @author: miaochen
 * @create: 2020-05-18 22:22
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class CoreConstant {
    // 用户状态标识位
    public static final String USER_LOCK = "L";    //用户锁定
    public static final String USER_NONE = "N";     //用户正常

    // 资源类型标识
    public static final String RESOURCE_GROUP = "G";     //菜单组
    public static final String RESOURCE_MENU = "M";     //菜单
    public static final String RESOURCE_BUTTON = "O";     //按钮

    // 是否为默认值
    public static final Integer IS_DEFAULT_N = 0;     //否
    public static final Integer IS_DEFAULT_Y = 1;     //是

    // 定时任务执行状态
    public static final Integer TASK_STATUS_NOMARL = 0;     //正常
    public static final Integer TASK_STATUS_ERROR = 1;     //异常

    public static final String USER_AUTH_CACHE_KEY = "user_auth_%s";
}
