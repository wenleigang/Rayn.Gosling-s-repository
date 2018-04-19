package com.chaosquark.backend.entity.vo;

import com.chaosquark.backend.common.enums.ResponseStatusEnum;
import com.chaosquark.backend.entity.BizException;

import java.io.Serializable;

/**
 * @ClassName: ResponseVo
 * @Description: 返回值包装实体类
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/19/019 11:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/19/019 11:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ResponseVo<T> implements Serializable {
    private static final long serialVersionUID = -223689668638061857L;
    private Integer code;
    private String msg;
    private T data;
    private String description;
    private String uri;
    private Long dataTime = System.currentTimeMillis();

    public ResponseVo() {

    }

    public ResponseVo(ResponseStatusEnum status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.description = status.getDescription();
    }

    public ResponseVo(BizException bizException) {
        this.code = bizException.getCode();
        this.msg = bizException.getMsg();
        this.description = bizException.getDescription();
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getDataTime() {
        return dataTime;
    }

    public void setDataTime(Long dataTime) {
        this.dataTime = dataTime;
    }
}
