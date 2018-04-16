package com.chaosquark.backend.common.enums;

import com.chaosquark.backend.common.interfaces.EnumIntegerValue;

public enum BillCategoryEnum implements EnumIntegerValue {

    CLUB_FEE(1, "队费"),
    CLUB_EVENT(2, "球队活动"),
    PUNISH_FEE(3, "罚款"),

    OTHER(0, "其他");

    private final int value;
    private final String info;

    BillCategoryEnum(int value, String info) {
        this.value = value;
        this.info = info;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getInfo() {
        return info;
    }

    public static  BillCategoryEnum get(int value) {
        for (BillCategoryEnum billCategoryEnum : values()) {
            if(billCategoryEnum.getValue() == value) {
                return billCategoryEnum;
            }
        }
        return null;
    }
}
