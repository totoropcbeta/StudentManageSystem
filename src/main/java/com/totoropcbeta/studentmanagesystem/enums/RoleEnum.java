package com.totoropcbeta.studentmanagesystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {

    STUDENT("STUDENT", "学生"),
    TEACHER("TEACHER", "教师"),
    ADMIN("ADMIN", "管理"),
    LOGISTICS("LOGISTICS", "后勤");


    private final String code;
    private final String value;

}
