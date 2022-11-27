package com.totoropcbeta.studentmanagesystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(1, "成功"),
    FAIL(0, "失败");

    private final Integer status;

    private final String message;
}
