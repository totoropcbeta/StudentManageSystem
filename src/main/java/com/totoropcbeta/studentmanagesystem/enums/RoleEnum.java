package com.totoropcbeta.studentmanagesystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {

    STUDENT(1, "STUDENT", "学生"),
    TEACHER(2, "TEACHER", "教师"),
    ADMIN(3, "ADMIN", "管理"),
    LOGISTICS(4, "LOGISTICS", "后勤");


    private final Integer roleId;
    private final String code;
    private final String value;

}
