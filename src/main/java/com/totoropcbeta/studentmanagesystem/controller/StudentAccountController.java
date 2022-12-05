package com.totoropcbeta.studentmanagesystem.controller;

import com.totoropcbeta.studentmanagesystem.bo.ResetValidInfo;
import com.totoropcbeta.studentmanagesystem.entity.StudentAccount;
import com.totoropcbeta.studentmanagesystem.provider.AuthProvider;
import com.totoropcbeta.studentmanagesystem.service.StudentAccountService;
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
@RequestMapping(value = "/student/account")
@Api(tags = "学生账号管理")
public class StudentAccountController {
    @Autowired
    private StudentAccountService studentAccountService;

    @RequestMapping(value = "/own-info", method = RequestMethod.GET)
    @ApiOperation(value = "获取学生个人账号信息")
    public ResultVo getStudentAccountInfo() {
        String loginAccount = AuthProvider.getLoginAccount();
        StudentAccount studentAccount = studentAccountService.getOne(loginAccount);
        return ResultVo.success(studentAccount);
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    @ApiOperation(value = "重置密码")
    public ResultVo resetPassWord(@Valid @RequestBody ResetValidInfo resetValidInfo) {
        studentAccountService.resetPassWord(resetValidInfo);
        return ResultVo.success("success");
    }
}
