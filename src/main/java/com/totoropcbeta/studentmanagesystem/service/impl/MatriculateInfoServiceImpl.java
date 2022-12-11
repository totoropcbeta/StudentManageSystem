package com.totoropcbeta.studentmanagesystem.service.impl;

import cn.hutool.core.lang.Assert;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.totoropcbeta.studentmanagesystem.entity.MatriculateStudent;
import com.totoropcbeta.studentmanagesystem.listener.MatriculateStudentListener;
import com.totoropcbeta.studentmanagesystem.mapper.MatriculateStudentMapper;
import com.totoropcbeta.studentmanagesystem.service.MatriculateInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yuanhang08
 * @date 2022年12月10日
 */
@Service
@Slf4j
public class MatriculateInfoServiceImpl implements MatriculateInfoService {
    @Autowired
    private MatriculateStudentMapper matriculateStudentMapper;

    @Override
    public List<MatriculateStudent> importMatriculateStudent(MultipartFile file) {
        // 读取文件
        ExcelReaderBuilder excelReader;
        InputStream fileInputStream;
        try {
            fileInputStream = file.getInputStream();
            excelReader = EasyExcel.read(fileInputStream, MatriculateStudent.class, new MatriculateStudentListener());
            // 封装工作表
            ExcelReaderSheetBuilder sheet0 = excelReader.sheet(0);
            // 读取内容
            sheet0.doRead();
            List<MatriculateStudent> matriculateStudentList = MatriculateStudentListener.getMatriculateStudentList();
            int col = matriculateStudentMapper.batchInsertSelective(matriculateStudentList);
            Assert.isTrue(col == matriculateStudentList.size(), "保存数据时出现错误");
            return matriculateStudentList;
        } catch (IOException e) {
            throw new RuntimeException("读取文件出现错误,错误信息: ", e);
        }
    }
}
