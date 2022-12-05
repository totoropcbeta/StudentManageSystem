package com.totoropcbeta.studentmanagesystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "com.totoropcbeta.studentmanagesystem.entity.StudentAccount")
@Data
public class StudentAccount {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "studentId学生学号（账号）")
    private String studentId;

    @ApiModelProperty(value = "studentName学生姓名")
    private String studentName;

    @ApiModelProperty(value = "passWord学生账号密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 可接收参数,而不会序列化字符串,即不返回该字段给前端
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