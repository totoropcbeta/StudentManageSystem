package com.totoropcbeta.studentmanagesystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "用户与角色关联表")
@Data
public class UserRoleLink {
    @ApiModelProperty(value = "用户与角色关联表主键")
    private Integer id;

    @ApiModelProperty(value = "用户信息表用户ID")
    private String userId;

    @ApiModelProperty(value = "角色信息表主键")
    private Integer roleId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
