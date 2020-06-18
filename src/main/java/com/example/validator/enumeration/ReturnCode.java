package com.example.validator.enumeration;

/**
 * 返回码定义
 */
public enum ReturnCode {
    /**
     *
     */
    success(200, "操作成功"),
    empty(201, "资源为空"),
    tokenExpire(401, "token expire"),
    serverError(500, "服务端错误"),
    fail(600, "操作失败"),
    notAllowedDelete(601, "不符合删除条件"),
    parameterError(602, "参数异常"),
    notAllowedUpdate(603, "不符合修改条件"),
    name_repeat(100001, "名称重复"),
    data_not_null(100002, "参数不能为空"),
    password_not_true(100003, "密码不正确"),
    object_not_exit(100004, "对象不存在"),
    object_exited(100005, "对象已存在"),
    PERMISSION_SIGNATURE_ERROR(1001, "签名失败"),
    USER_INEXISTENCE(1002, "用户名不存在"),
    USER_INFO_ERROR(1003, "用户名或密码错误"),
    ROLE_CODE_EXIT(100006,"角色code重复"),
    INVALID_OPERATING(100007,"无效的操作"),
    USER_NAME_EXIT(100008,"用户名已存在");

    private Integer code;
    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
