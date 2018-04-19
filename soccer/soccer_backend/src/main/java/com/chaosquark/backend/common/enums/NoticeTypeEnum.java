package com.chaosquark.backend.common.enums;

import com.chaosquark.backend.common.interfaces.EnumIntegerValue;

public enum NoticeTypeEnum implements EnumIntegerValue {

    MATCH(1, "比赛"),
    PARTY(2, "派对"),

    OTHER(0, "其他");

    Integer value;
    String info;

    NoticeTypeEnum(Integer value, String info) {
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

    public static NoticeTypeEnum get(Integer value) {
        for (NoticeTypeEnum noticeTypeEnum : values()) {
            if(noticeTypeEnum.getValue() == value) {
                return noticeTypeEnum;
            }
        }
        return null;
    }

}
