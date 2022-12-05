package com.totoropcbeta.studentmanagesystem.controller;

import com.totoropcbeta.studentmanagesystem.entity.StudentAccount;
import com.totoropcbeta.studentmanagesystem.provider.AuthProvider;
import com.totoropcbeta.studentmanagesystem.service.StudentAccountService;
import com.totoropcbeta.studentmanagesystem.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
