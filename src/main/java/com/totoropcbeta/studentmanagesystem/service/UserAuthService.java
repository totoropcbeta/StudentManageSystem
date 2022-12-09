package com.totoropcbeta.studentmanagesystem.service;

import com.totoropcbeta.studentmanagesystem.bo.AccessToken;

/**
 * @author yuanhang08
 * @date 2022年12月04日
 */
public interface UserAuthService {

    AccessToken login(String student_id, String passWord);

    void logout();

    AccessToken refreshToken(String token);
}
