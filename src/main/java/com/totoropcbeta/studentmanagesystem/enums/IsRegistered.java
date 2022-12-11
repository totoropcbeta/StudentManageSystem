package com.totoropcbeta.studentmanagesystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuanhang08
 * @date 2022年12月11日
 */
@Getter
@AllArgsConstructor
public enum IsRegistered {
    Registered(1, "已注册"),
    UNRegistered(0, "未注册");
    private final Integer code;
    private final String value;

    public Byte getCode() {
        return code.byteValue();
    }
}
