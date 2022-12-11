package com.totoropcbeta.studentmanagesystem.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import com.totoropcbeta.studentmanagesystem.entity.MatriculateStudent;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuanhang08
 * @date 2022年12月10日
 */
@Slf4j
public class MatriculateStudentListener implements ReadListener<MatriculateStudent> {
    private static final List<MatriculateStudent> matriculateStudentList = new ArrayList<>();

    public static List<MatriculateStudent> getMatriculateStudentList() {
        return matriculateStudentList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public void invoke(MatriculateStudent matriculateStudent, AnalysisContext analysisContext) {
        matriculateStudentList.add(matriculateStudent);
        log.info("解析到一条数据: {}", JSON.toJSONString(matriculateStudent));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据解析完成.");
    }
}
