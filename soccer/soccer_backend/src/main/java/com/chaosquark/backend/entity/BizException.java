package com.chaosquark.backend.entity;

import com.chaosquark.backend.common.enums.ResponseStatusEnum;

/**
 * @ClassName: BizException
 * @Description: 自定义业务异常类，必须处理
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/19/019 11:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/19/019 11:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = -1595327868077246938L;

    private Integer code;
    private String msg;
    private String description;

    public BizException(ResponseStatusEnum status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.description = status.getDescription();
    }

    public BizException(Exception exception) {
        this.code = ResponseStatusEnum.SERVER_ERROR.getCode();
        this.msg = ResponseStatusEnum.SERVER_ERROR.getMsg();
        this.description = exception.toString();
    }

    public BizException(Throwable throwable) {
        this.code = ResponseStatusEnum.SERVER_ERROR.getCode();
        this.msg = ResponseStatusEnum.SERVER_ERROR.getMsg();
        this.description = throwable.getMessage();
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
