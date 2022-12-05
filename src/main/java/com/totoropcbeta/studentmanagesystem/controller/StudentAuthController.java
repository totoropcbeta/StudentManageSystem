package com.totoropcbeta.studentmanagesystem.controller;

import com.totoropcbeta.studentmanagesystem.bo.AccessToken;
import com.totoropcbeta.studentmanagesystem.bo.LoginInfo;
import com.totoropcbeta.studentmanagesystem.service.StudentAuthService;
import com.totoropcbeta.studentmanagesystem.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanhang08
 * @date 2022年12月04日
 */
@RestController
@RequestMapping(value = "/student/auth")
@Api(tags = "学生账号认证")
public class StudentAuthController {
    @Autowired
    private StudentAuthService studentAuthService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录账号")
    public ResultVo login(@RequestBody LoginInfo loginInfo) {
        AccessToken login = studentAuthService.login(loginInfo.getLoginAccount(), loginInfo.getPassWord());
        return ResultVo.success(login);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "注销账号")
    public ResultVo logout() {
        return ResultVo.success(null);
    }

    @RequestMapping(value = "/refresh-token", method = RequestMethod.POST)
    @ApiOperation(value = "刷新token")
    public ResultVo refreshToken() {
        return ResultVo.success(null);
    }


}
