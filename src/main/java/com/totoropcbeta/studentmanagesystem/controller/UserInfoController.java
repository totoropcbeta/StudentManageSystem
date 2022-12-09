package com.totoropcbeta.studentmanagesystem.controller;

import com.totoropcbeta.studentmanagesystem.bo.ResetValidInfo;
import com.totoropcbeta.studentmanagesystem.entity.UserInfo;
import com.totoropcbeta.studentmanagesystem.provider.AuthProvider;
import com.totoropcbeta.studentmanagesystem.service.UserInfoService;
import com.totoropcbeta.studentmanagesystem.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yuanhang08
 * @date 2022年12月05日
 */
@RestController
@RequestMapping(value = "/user/account")
@Api(tags = "用户账号管理")
public class UserInfoController {
    @Autowired
    private UserInfoService UserInfoService;

    @RequestMapping(value = "/own-info", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户个人账号信息")
    public ResultVo getUserInfoInfo() {
        String userId = AuthProvider.getUserId();
        UserInfo UserInfo = UserInfoService.getOne(userId);
        return ResultVo.success(UserInfo);
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    @ApiOperation(value = "重置密码")
    public ResultVo resetPassWord(@Valid @RequestBody ResetValidInfo resetValidInfo) {
        UserInfoService.resetPassWord(resetValidInfo);
        return ResultVo.success("success");
    }
}
