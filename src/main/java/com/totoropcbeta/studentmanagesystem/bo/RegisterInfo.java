package com.totoropcbeta.studentmanagesystem.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yuanhang08
 * @date 2022年12月10日
 */
@Data
@ApiModel(value = "用户注册需提交的信息")
public class RegisterInfo {
    @ApiModelProperty(required = true, value = "用户姓名")
    private String userName;
    @ApiModelProperty(required = true, value = "用户身份证")
    private String idCard;
    @ApiModelProperty(required = true, value = "用户密码")
    private String password;
    @ApiModelProperty(required = true, value = "用户手机号")
    private String phone;
    @ApiModelProperty(required = true, value = "用户邮箱")
    private String email;
}
