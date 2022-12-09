package com.totoropcbeta.studentmanagesystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "权限信息表")
@Data
public class PermissionInfo {
    @ApiModelProperty(value = "权限表主键")
    private Integer id;

    @ApiModelProperty(value = "权限名称")
    private String permissionName;

    @ApiModelProperty(value = "权限URI")
    private String permissionUri;

    @ApiModelProperty(value = "权限方法类型")
    private String permissionMethod;

    @ApiModelProperty(value = "是否有效（0-无效,1-有效）")
    private Byte activeStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
