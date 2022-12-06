package com.totoropcbeta.studentmanagesystem.service.impl;


import com.totoropcbeta.studentmanagesystem.bo.UserDetail;
import com.totoropcbeta.studentmanagesystem.entity.RoleInfo;
import com.totoropcbeta.studentmanagesystem.entity.StudentAccount;
import com.totoropcbeta.studentmanagesystem.service.RoleInfoService;
import com.totoropcbeta.studentmanagesystem.service.StudentAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentAccountService studentAccountService;
    @Autowired
    private RoleInfoService roleInfoService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("开始登陆验证,用户名为: {}", s);

        // 根据用户名验证用户
        StudentAccount account = studentAccountService.getOne(s);
        if (account == null) {
            throw new UsernameNotFoundException("用户名不存在,登陆失败.");
        }
        UserDetail userDetail = new UserDetail();
        userDetail.setStudentAccount(account);
        List<RoleInfo> roleInfos = roleInfoService.listRoleByUserId(account.getId());
        userDetail.setRoleInfoList(roleInfos);
        log.info("获取到的userDetail: {}", userDetail);
        return userDetail;
    }
}
