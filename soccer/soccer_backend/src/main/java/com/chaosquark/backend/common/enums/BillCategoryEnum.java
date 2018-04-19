package com.chaosquark.backend.common.enums;

import com.chaosquark.backend.common.interfaces.EnumIntegerValue;

public enum BillCategoryEnum implements EnumIntegerValue {

    CLUB_FEE(1, "队费"),
    CLUB_EVENT(2, "球队活动"),
    PUNISH_FEE(3, "罚款"),

    OTHER(0, "其他");

    Integer value;
    String info;

    BillCategoryEnum(Integer value, String info) {
        this.value = value;
        this.info = info;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getInfo() {
        return info;
    }

    public static  BillCategoryEnum get(Integer value) {
        for (BillCategoryEnum billCategoryEnum : values()) {
            if(billCategoryEnum.getValue() == value) {
                return billCategoryEnum;
            }
        }
        return null;
    }
}
