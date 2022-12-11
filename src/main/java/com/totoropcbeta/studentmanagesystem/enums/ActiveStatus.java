package com.totoropcbeta.studentmanagesystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActiveStatus {
    ACTIVE(1, "有效"),
    INACTIVE(0, "失效");

    private final Integer code;
    private final String value;


    public Byte getCode() {
        return code.byteValue();
    }
}
