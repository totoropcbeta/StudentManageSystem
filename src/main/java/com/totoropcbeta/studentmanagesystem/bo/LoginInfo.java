package com.totoropcbeta.studentmanagesystem.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginInfo {

    @NotBlank(message = "登陆用户名不能为空")
    private String userId;

    @NotBlank(message = "登陆密码不能为空")
    private String password;
}
