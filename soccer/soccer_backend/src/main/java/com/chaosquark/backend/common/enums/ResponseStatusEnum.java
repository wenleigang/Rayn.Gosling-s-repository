package com.chaosquark.backend.common.enums;

/**
 * @ClassName: ResponseStatusEnum
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/19/019 13:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/19/019 13:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum ResponseStatusEnum {
    // ================================================controller相关====================================================================

    /**
     * 操作成功
     */
    OK(200, "successful", "成功"),

    /**
     * 删除失败
     */
    FAILURE_DELETE(10002, "Delete Failure", "删除失败"),
    /**
     * 添加失败
     */
    FAILURE_ADD(10003, "Add Failure", "添加失败"),
    /**
     * 修改失败
     */
    FAILURE_UPDATE(10004, "Update Failure", "修改失败"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(10005, "unknown error"),


    API_SUCCESS(200, "successful", "成功"),

    /**
     * Token authenication failure/Token 认证失败
     */
    TOKEN_AUTHENTICATION_FAILURE(20000, "Token authenication failure"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(20001, "System error"),

    /**
     * 缺失必选参数，请参考API文档
     */
    MISS_REQUIRED_PARAMETE(20002, "缺失必选参数，请参考API文档"),
    /**
     * 参数值非法
     */
    PARAMETER_VALUE_ILLEGAL(20003, "参数值非法"),

    /**
     * Request API not found!
     */
    REQUEST_API_NOT_FOUND(20004, "Request API not found!"),

    // ================================================shiro相关====================================================================

    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXIST(30001, "账号不存在"),
    /**
     * 用户名/密码错误
     */
    WRONG_PWD(30002, "密码错误"),
    /**
     * 验证码错误
     */
    ERROR_VALIDATE_CODE(30003, "验证码错误"),

    USER_BLOCKED(30004, "用户已禁用"),

    /**
     * user.unknown.error
     */
    USER_UNKNOWN_ERROR(30005, "user.unknown.error"),
    /**
     * user.not.exists
     */
    USER_NOT_EXISTS(30006, "用户不存在"),
    /**
     * user.userNameorPassword.not.match
     */
    USER_PASSWORD_NOT_MATCH(30007, "用户名和密码不匹配"),
    /**
     * 账号已锁定
     */
    ACCOUNT_LOCKED(30008, "账号已锁定"),

    /**
     * 该用户已注册
     */
    HAVE_ALREADY_REGISTERED(30009, "该手机号码已注册"),

    /**
     * 账号已过期
     */
    ACCOUNT_EXPIRED(30010, "Account has expired!", "该账号已过期"),

    /**
     * 用户身份有误
     */
    USER_IDENTITY_VALID(30011, "user.identity.error", "用户身份有误"),

    /**
     * 用户名为空
     */
    USER_NAME_IS_NULL(30012, "user name is null", "用户名为空"),

    /**
     * 密码为空
     */
    PASSWORD_IS_NULL(30013, "password is null", "密码为空"),

    /**
     * 非法用户
     */
    ILLEGAL_USER_ACCOUNT(30014, "非法用户"),

    /**
     * 非法手机号
     */
    ILLEGAL_MOBILE_PHONE(30015, "非法手机号"),

    /**
     * 获取验证码失败
     */
    GET_CODE_ERROR(30016, "获取验证码失败"),

    /**
     * 非法密码
     */
    ILLEGAL_PASSWORD(30017, "密码由6-16位数字或字母组成"),

    // ========================================================前台用户资料、认证状态===========================================================================


    // =========================================================HTTP异常码====================================================================================

    REQUEST_GRAMMAR_ERROR(400, "请求语法错误"),

    FORBIDDEN_REQUEST(403, "访问被拒绝"),

    REQUEST_NOT_FOUND(404, "无法找到对应资源"),

    SERVER_ERROR(500, "服务器内部错误");

    Integer code;
    String msg;
    String description;

    ResponseStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResponseStatusEnum(Integer code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    public static ResponseStatusEnum nameOf(String name) {
        for (ResponseStatusEnum responseStatus : values()) {
            if(responseStatus.name().equals(name)) {
                return responseStatus;
            }
        }
        return null;
    }

    public static ResponseStatusEnum codeOf(int code) {
        for (ResponseStatusEnum responseStatus : values()) {
            if(responseStatus.getCode() == code) {
                return responseStatus;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
