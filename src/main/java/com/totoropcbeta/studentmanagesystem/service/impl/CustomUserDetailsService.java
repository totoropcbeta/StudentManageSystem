package com.totoropcbeta.studentmanagesystem.service.impl;


import cn.hutool.core.lang.Assert;
import com.totoropcbeta.studentmanagesystem.bo.UserDetail;
import com.totoropcbeta.studentmanagesystem.entity.RoleInfo;
import com.totoropcbeta.studentmanagesystem.entity.UserInfo;
import com.totoropcbeta.studentmanagesystem.service.RoleInfoService;
import com.totoropcbeta.studentmanagesystem.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Slf4j
@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoService UserInfoService;
    @Autowired
    private RoleInfoService roleInfoService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("开始登陆验证,用户名为: {}", userId);

        // 根据用户名验证用户
        UserInfo userInfo = UserInfoService.getOne(userId);
        Assert.isTrue(Objects.nonNull(userInfo), "用户名或密码错误,请重试.");
        UserDetail userDetail = new UserDetail();
        userDetail.setUserInfo(userInfo);
        List<RoleInfo> roleInfos = roleInfoService.listRoleByUserId(userInfo.getId());
        userDetail.setRoleInfoList(roleInfos);
        log.info("生成的userDetail: {}", userDetail);
        return userDetail;
    }
}
