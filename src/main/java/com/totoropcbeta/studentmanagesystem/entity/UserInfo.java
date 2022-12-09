package com.totoropcbeta.studentmanagesystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "用户信息表")
@Data
public class UserInfo {
    @ApiModelProperty(value = "用户表主键")
    private Integer id;

    @ApiModelProperty(value = "用户账号ID")
    private String userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 不参与序列化,该字段不返回给前端
    private String password;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "用户身份证")
    private String idCard;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "是否有效（0-无效,1-有效）")
    private Byte activeStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
