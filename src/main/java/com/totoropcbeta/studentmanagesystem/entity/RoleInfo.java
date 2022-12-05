package com.totoropcbeta.studentmanagesystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "com.totoropcbeta.studentmanagesystem.entity.RoleInfo")
@Data
public class RoleInfo {
    @ApiModelProperty(value = "id角色表主键")
    private Integer id;

    @ApiModelProperty(value = "roleName角色名称")
    private String roleName;

    @ApiModelProperty(value = "roleCode角色编码")
    private String roleCode;

    @ApiModelProperty(value = "roleRemark角色备注")
    private String roleRemark;

    @ApiModelProperty(value = "activeStatus逻辑删除")
    private Byte activeStatus;

    @ApiModelProperty(value = "createTime角色创建时间")
    private Date createTime;
}