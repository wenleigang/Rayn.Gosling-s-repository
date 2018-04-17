package com.chaosquark.backend.common.enums;

import com.chaosquark.backend.common.interfaces.EnumIntegerValue;

/**
 * @ClassName: StaffStatusEnum
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/17/017 16:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/17/017 16:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum StaffStatusEnum implements EnumIntegerValue {
    OUT_SERVICE(0, "离职"),
    IN_SERVICE(0, "在职"),
    IN_HOLIDAY(0, "休假");

    private final int value;
    private final String info;

    StaffStatusEnum(int value, String info) {
        this.value = value;
        this.info = info;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    public static StaffStatusEnum get(int value) {
        for (StaffStatusEnum staffStatusEnum : values()) {
            if (staffStatusEnum.getValue() == value) {
                return staffStatusEnum;
            }
        }
        return null;
    }
}
