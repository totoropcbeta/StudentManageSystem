package com.totoropcbeta.studentmanagesystem.service;

import com.totoropcbeta.studentmanagesystem.bo.AccessToken;
import com.totoropcbeta.studentmanagesystem.bo.RegisterInfo;

/**
 * @author yuanhang08
 * @date 2022年12月04日
 */
public interface UserAuthService {

    AccessToken login(String user_id, String password);

    void logout();

    AccessToken refreshToken(String token);

    String register(RegisterInfo registerInfo);
}
