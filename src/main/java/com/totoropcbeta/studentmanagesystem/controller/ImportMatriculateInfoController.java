package com.totoropcbeta.studentmanagesystem.controller;

import cn.hutool.core.lang.Assert;
import com.totoropcbeta.studentmanagesystem.entity.MatriculateStudent;
import com.totoropcbeta.studentmanagesystem.service.MatriculateInfoService;
import com.totoropcbeta.studentmanagesystem.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author yuanhang08
 * @date 2022年12月10日
 */
@RestController
@Api(tags = "导入录取信息接口")
@RequestMapping(value = "/matriculate-info")
public class ImportMatriculateInfoController {
    @Autowired
    private MatriculateInfoService matriculateInfoService;

    @RequestMapping(value = "/import/student", method = RequestMethod.POST)
    @ApiOperation(value = "导入已录取学生信息")
    public ResultVo importMatriculateStudent(@RequestParam(value = "file") @ApiParam(value = "file", required = true) MultipartFile file) throws IOException {
        Assert.isFalse(file.isEmpty(), "文件内容为空");
        List<MatriculateStudent> matriculateStudents = matriculateInfoService.importMatriculateStudent(file);
        return ResultVo.success(matriculateStudents);
    }
}
