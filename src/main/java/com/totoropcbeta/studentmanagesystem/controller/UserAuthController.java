package com.totoropcbeta.studentmanagesystem.controller;

import com.totoropcbeta.studentmanagesystem.bo.AccessToken;
import com.totoropcbeta.studentmanagesystem.bo.LoginInfo;
import com.totoropcbeta.studentmanagesystem.bo.RegisterInfo;
import com.totoropcbeta.studentmanagesystem.provider.JwtProvider;
import com.totoropcbeta.studentmanagesystem.service.UserAuthService;
import com.totoropcbeta.studentmanagesystem.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * @author yuanhang08
 * @date 2022年12月04日
 */
@RestController
@RequestMapping(value = "/user/auth")
@Api(tags = "用户账号认证")
@Validated
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private JwtProvider jwtProvider;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册账号")
    public ResultVo register(@Valid @RequestBody RegisterInfo registerInfo) {
        String userId = userAuthService.register(registerInfo);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("user_id", userId);
        return ResultVo.success(hashMap);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录账号")
    public ResultVo login(@Valid @RequestBody LoginInfo loginInfo) {
        AccessToken login = userAuthService.login(loginInfo.getUserId(), loginInfo.getPassword());
        return ResultVo.success(login);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "登出账号")
    public ResultVo logout() {
        userAuthService.logout();
        return ResultVo.success("success");
    }

    @RequestMapping(value = "/refresh-token", method = RequestMethod.POST)
    @ApiOperation(value = "刷新token")
    public ResultVo refreshToken(HttpServletRequest request) {
        AccessToken accessToken = userAuthService.refreshToken(jwtProvider.getToken(request));
        return ResultVo.success(accessToken);
    }


}
