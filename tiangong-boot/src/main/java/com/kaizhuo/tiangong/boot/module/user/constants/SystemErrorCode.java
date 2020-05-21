package com.kaizhuo.tiangong.boot.module.user.constants;

public enum SystemErrorCode {
    SYSTEM_PARAM_CANNOT_DELETE_ERROR(22000, "系统参数不可删除"),

    // 各业务服务使用从2xxxx - 8xxxx的状态码
    ;

    private final int code;
    private final String desc;

    SystemErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static final String fromValue(int value) {
        for (SystemErrorCode e : values()) {
            if (e.code == value) {
                return e.getDesc();
            }
        }
        return null;
    }
}
