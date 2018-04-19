package com.chaosquark.backend.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

 /**
  *
  * @ClassName:      BaseEntity
  * @Description:    基础属性实体类描述
  * @Author:         唐朝
  * @CreateDate:     2018/4/17/017 13:57
  * @UpdateUser:     更新者
  * @UpdateDate:     2018/4/17/017 13:57
  * @UpdateRemark:   更新内容
  * @Version:        1.0
  */
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 4521956696739761334L;

    //创建人id
    @Column(name = "create_uid")
    protected Long createUid;
    //创建时间
    @Column(name = "create_time")
    protected Date createTime;
    //修改人id
    @Column(name = "modify_uid")
    protected Long modifyUid;
    //修改时间
    @Column(name = "modify_time")
    protected Date modifyTime;
    //是否逻辑删除
    protected Boolean deleted;

    public abstract Long getId();

    public abstract void setId(Long id);

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
     this.createTime = createTime;
    }

    public Long getModifyUid() {
        return modifyUid;
    }

    public void setModifyUid(Long modifyUid) {
        this.modifyUid = modifyUid;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
     this.modifyTime = modifyTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
 }
