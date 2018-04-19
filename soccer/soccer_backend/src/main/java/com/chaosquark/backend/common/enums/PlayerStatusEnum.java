package com.chaosquark.backend.common.enums;

import com.chaosquark.backend.common.interfaces.EnumIntegerValue;

/**
 * @ClassName: PlayerStatusEnum
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/17/017 17:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/17/017 17:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum PlayerStatusEnum implements EnumIntegerValue {
    OUT_SERVICE(0, "未服役"),
    IN_SERVICE(1, "在服役"),
    LEASE(2, "租借"),
    RETIRED(3, "已退役");

    Integer value;
    String info;

    PlayerStatusEnum(Integer value, String info) {
        this.value = value;
        this.info = info;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    public static PlayerStatusEnum get(Integer value) {
        for (PlayerStatusEnum playerStatusEnum : values()) {
            if(playerStatusEnum.getValue() == value) {
                return playerStatusEnum;
            }
        }
        return null;
    }
}
