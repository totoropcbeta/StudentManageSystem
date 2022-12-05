package com.totoropcbeta.studentmanagesystem.service.impl;

import cn.hutool.core.lang.Assert;
import com.totoropcbeta.studentmanagesystem.bo.ResetValidInfo;
import com.totoropcbeta.studentmanagesystem.entity.StudentAccount;
import com.totoropcbeta.studentmanagesystem.entity.example.StudentAccountExample;
import com.totoropcbeta.studentmanagesystem.mapper.StudentAccountMapper;
import com.totoropcbeta.studentmanagesystem.service.StudentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        StudentAccount studentAccount = studentAccountMapper.selectOneByStudentId(studentId);
        return studentAccount;
    }

    @Override
    public void resetPassWord(ResetValidInfo resetValidInfo) {
        String phone = resetValidInfo.getPhone();
        String idCard = resetValidInfo.getIdCard();
        String email = resetValidInfo.getEmail();
        StudentAccountExample studentAccountExample = new StudentAccountExample();
        studentAccountExample.createCriteria().andPhoneEqualTo(phone).andIdCardEqualTo(idCard).andEmailEqualTo(email);
        List<StudentAccount> studentAccounts = studentAccountMapper.selectByExample(studentAccountExample);
        Assert.isTrue(studentAccounts.size() == 1, "验证信息有误,未找到有效账号.");
        String newPassword = resetValidInfo.getNewPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(newPassword); // 明文密码加密
        StudentAccount studentAccount = new StudentAccount();
        studentAccount.setPassWord(encodePassword);
        int col = studentAccountMapper.updateByExampleSelective(studentAccount, studentAccountExample);
        Assert.isTrue(col == 1, "密码重置失败");
    }
}
