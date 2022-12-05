package com.totoropcbeta.studentmanagesystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "com.totoropcbeta.studentmanagesystem.entity.PermissionInfo")
@Data
public class PermissionInfo {
    @ApiModelProperty(value = "id权限表主键")
    private Integer id;

    @ApiModelProperty(value = "permissionName权限名称")
    private String permissionName;

    @ApiModelProperty(value = "permissionUri权限URI")
    private String permissionUri;

    @ApiModelProperty(value = "permissionMethod权限方法类型")
    private String permissionMethod;

    @ApiModelProperty(value = "activeStatus逻辑删除")
    private Byte activeStatus;

    @ApiModelProperty(value = "createTime权限创建时间")
    private Date createTime;
}