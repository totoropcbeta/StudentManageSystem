package com.totoropcbeta.studentmanagesystem.service.impl;

import com.totoropcbeta.studentmanagesystem.entity.StudentAccount;
import com.totoropcbeta.studentmanagesystem.mapper.StudentAccountMapper;
import com.totoropcbeta.studentmanagesystem.service.StudentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanhang08
 * @date 2022年12月05日
 */
@Service
public class StudentAccountServiceImpl implements StudentAccountService {
    @Autowired
    private StudentAccountMapper studentAccountMapper;

    @Override
    public StudentAccount getOne(String studentId) {
        StudentAccount studentAccount = studentAccountMapper.selectOneByExample(studentId);
        return studentAccount;
    }
}
