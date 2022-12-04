package com.totoropcbeta.studentmanagesystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "com.totoropcbeta.studentmanagesystem.entity.StudentAccount")
@Data
public class StudentAccount {
    @ApiModelProperty(value = "id学生学号（账号）")
    private Integer id;

    @ApiModelProperty(value = "name学生姓名")
    private String name;

    @ApiModelProperty(value = "passWord学生账号密码")
    private String passWord;

    @ApiModelProperty(value = "phone学生手机号")
    private String phone;

    @ApiModelProperty(value = "idCard学生身份证")
    private String idCard;

    @ApiModelProperty(value = "email学生邮箱")
    private String email;

    @ApiModelProperty(value = "valid是否有效（0-无效,1-有效）")
    private Boolean valid;

    @ApiModelProperty(value = "createTime创建时间")
    private Date createTime;

    @ApiModelProperty(value = "updateTime更新时间")
    private Date updateTime;
}