package com.chaosquark.backend.common.entity;

/**
 * @ClassName: IdEntity
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/17/017 14:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/17/017 14:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class IdEntity extends BaseEntity {
    private static final long serialVersionUID = -7873242355547784718L;

    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (this.createTime == null ? 0 : this.createTime.hashCode());
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        result = 31 * result + (this.modifyTime == null ? 0 : this.modifyTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!super.equals(obj)) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            IdEntity other = (IdEntity) obj;
            if (this.createTime == null) {
                if (other.createTime != null) {
                    return false;
                }
            } else if (!this.createTime.equals(other.createTime)) {
                return false;
            }

            if (this.id == null) {
                if (other.id != null) {
                    return false;
                }
            } else if (!this.id.equals(other.id)) {
                return false;
            }
            if (this.modifyTime == null) {
                if (other.modifyTime != null) {
                    return false;
                }
            } else if (!this.modifyTime.equals(other.modifyTime)) {
                return false;
            }

            return true;
        }
    }
}
