package com.totoropcbeta.studentmanagesystem.service;

import com.totoropcbeta.studentmanagesystem.entity.MatriculateStudent;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author yuanhang08
 * @date 2022年12月10日
 */
public interface MatriculateInfoService {
    List<MatriculateStudent> importMatriculateStudent(MultipartFile multipartFile) throws IOException;
}
