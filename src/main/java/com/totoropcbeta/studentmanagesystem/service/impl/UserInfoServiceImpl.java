package com.totoropcbeta.studentmanagesystem.service.impl;

import cn.hutool.core.lang.Assert;
import com.totoropcbeta.studentmanagesystem.bo.ResetValidInfo;
import com.totoropcbeta.studentmanagesystem.entity.UserInfo;
import com.totoropcbeta.studentmanagesystem.entity.example.UserInfoExample;
import com.totoropcbeta.studentmanagesystem.mapper.UserInfoMapper;
import com.totoropcbeta.studentmanagesystem.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanhang08
 * @date 2022年12月05日
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper UserInfoMapper;

    @Override
    public UserInfo getOne(String studentId) {
        UserInfo UserInfo = UserInfoMapper.selectOneByStudentId(studentId);
        return UserInfo;
    }

    @Override
    public void resetPassWord(ResetValidInfo resetValidInfo) {
        String phone = resetValidInfo.getPhone();
        String idCard = resetValidInfo.getIdCard();
        String email = resetValidInfo.getEmail();
        UserInfoExample UserInfoExample = new UserInfoExample();
        UserInfoExample.createCriteria().andPhoneEqualTo(phone).andIdCardEqualTo(idCard).andEmailEqualTo(email);
        List<UserInfo> UserInfos = UserInfoMapper.selectByExample(UserInfoExample);
        Assert.isTrue(UserInfos.size() == 1, "验证信息有误,未找到有效账号.");
        String newPassword = resetValidInfo.getNewPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(newPassword); // 明文密码加密
        UserInfo UserInfo = new UserInfo();
        UserInfo.setPassword(encodePassword);
        int col = UserInfoMapper.updateByExampleSelective(UserInfo, UserInfoExample);
        Assert.isTrue(col == 1, "密码重置失败");
    }
}
