package com.chaosquark.backend.common.enums;

import com.chaosquark.backend.common.interfaces.EnumIntegerValue;

public enum NoticeTypeEnum implements EnumIntegerValue {

    MATCH(1, "比赛"),
    PARTY(2, "派对"),

    OTHER(0, "其他");

    private final int value;
    private final String info;

    NoticeTypeEnum(int value, String info) {
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

    public static NoticeTypeEnum get(int value) {
        for (NoticeTypeEnum noticeTypeEnum : values()) {
            if(noticeTypeEnum.getValue() == value) {
                return noticeTypeEnum;
            }
        }
        return null;
    }

}
