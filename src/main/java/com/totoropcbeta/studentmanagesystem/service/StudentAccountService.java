package com.totoropcbeta.studentmanagesystem.service;

import com.totoropcbeta.studentmanagesystem.entity.StudentAccount;

/**
 * @author yuanhang08
 * @date 2022年12月05日
 */
public interface StudentAccountService {

    StudentAccount getOne(String studentId);

}
