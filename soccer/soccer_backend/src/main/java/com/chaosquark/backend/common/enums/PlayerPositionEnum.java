package com.chaosquark.backend.common.enums;

import com.chaosquark.backend.common.interfaces.EnumIntegerValue;

/**
 * @ClassName: PlayerPositionEnum
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/17/017 16:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/17/017 16:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum PlayerPositionEnum implements EnumIntegerValue {
    CF(1, "中锋"),
    SS(2, "二前锋/影子前锋"),
    WF(3, "边锋"),
    AMF(4, "前腰"),
    CMF(5, "前卫"),
    SMF(6, "边前卫"),
    DMF(7, "后腰"),
    SB(8, "边后卫"),
    CB(9, "中后卫"),
    SW(10, "清道夫"),
    GK(11, "门将");

    private final int value;
    private final String info;

    PlayerPositionEnum(int value, String info) {
        this.value = value;
        this.info = info;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getInfo() {
        return null;
    }

    public static PlayerPositionEnum get(int value) {
        for (PlayerPositionEnum playerPositionEnum : values()) {
            if(playerPositionEnum.getValue() == value) {
                return playerPositionEnum;
            }
        }
        return null;
    }
}
