package com.totoropcbeta.studentmanagesystem.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yuanhang08
 * @date 2022年12月05日
 */
@Data
@ApiModel(value = "重置密码时需校验的参数对象")
public class ResetValidInfo {
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;
    @NotBlank(message = "身份证号不能为空")
    @ApiModelProperty(value = "身份证号", required = true)
    private String idCard;
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(value = "邮箱", required = true)
    private String email;
    @NotBlank(message = "新密码不能为空")
    @ApiModelProperty(value = "新密码", required = true)
    private String newPassword;

}
