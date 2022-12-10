package com.totoropcbeta.studentmanagesystem.service;

import com.totoropcbeta.studentmanagesystem.bo.ResetValidInfo;
import com.totoropcbeta.studentmanagesystem.entity.UserInfo;

/**
 * @author yuanhang08
 * @date 2022年12月05日
 */
public interface UserInfoService {

    UserInfo getOne(String userId);

    void resetPassWord(ResetValidInfo resetValidInfo);

}
