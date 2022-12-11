package com.totoropcbeta.studentmanagesystem.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.totoropcbeta.studentmanagesystem.bo.AccessToken;
import com.totoropcbeta.studentmanagesystem.bo.RegisterInfo;
import com.totoropcbeta.studentmanagesystem.bo.UserDetail;
import com.totoropcbeta.studentmanagesystem.cache.Cache;
import com.totoropcbeta.studentmanagesystem.entity.MatriculateStudent;
import com.totoropcbeta.studentmanagesystem.entity.UserInfo;
import com.totoropcbeta.studentmanagesystem.entity.UserRoleLink;
import com.totoropcbeta.studentmanagesystem.entity.example.MatriculateStudentExample;
import com.totoropcbeta.studentmanagesystem.enums.ActiveStatus;
import com.totoropcbeta.studentmanagesystem.enums.CacheName;
import com.totoropcbeta.studentmanagesystem.enums.IsRegistered;
import com.totoropcbeta.studentmanagesystem.enums.RoleEnum;
import com.totoropcbeta.studentmanagesystem.mapper.MatriculateStudentMapper;
import com.totoropcbeta.studentmanagesystem.mapper.UserInfoMapper;
import com.totoropcbeta.studentmanagesystem.mapper.UserRoleLinkMapper;
import com.totoropcbeta.studentmanagesystem.provider.AuthProvider;
import com.totoropcbeta.studentmanagesystem.provider.JwtProvider;
import com.totoropcbeta.studentmanagesystem.service.UserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yuanhang08
 * @date 2022年12月04日
 */
@Service
@Slf4j
@Transactional
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private Cache caffeineCache;

    @Autowired
    private MatriculateStudentMapper matriculateStudentMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserRoleLinkMapper userRoleLinkMapper;


    @Override
    public AccessToken login(String userId, String password) {
        log.info("进入login方法...");
        // 1 创建UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken usernameAuthentication = new UsernamePasswordAuthenticationToken(userId, password);
        log.info("创建UsernamePasswordAuthenticationToken: {}", usernameAuthentication);
        // 2 认证
        Authentication authentication = this.authenticationManager.authenticate(usernameAuthentication);
        log.info("由CustomUserDetailsService.loadUserByUsername生成的认证主体 authentication: {}", authentication.getPrincipal().toString());
        // 3 保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 4 生成自定义token
        AccessToken accessToken = jwtProvider.createToken((UserDetail) authentication.getPrincipal());
        log.info("生成自定义token: {}", accessToken);
        UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        // 5 放入缓存
        caffeineCache.put(CacheName.USER, userDetail.getUserId(), userDetail);
        return accessToken;
    }

    @Override
    public void logout() {
        caffeineCache.remove(CacheName.USER, AuthProvider.getUserId());
        SecurityContextHolder.clearContext();
        log.info("用户 {} 成功注销登录", AuthProvider.getUserId());
    }

    @Override
    public AccessToken refreshToken(String token) {
        AccessToken accessToken = jwtProvider.refreshToken(token);
        UserDetail userDetail = caffeineCache.get(CacheName.USER, accessToken.getUserId(), UserDetail.class);
        caffeineCache.put(CacheName.USER, accessToken.getUserId(), userDetail);
        return accessToken;
    }

    @Override
    public String register(RegisterInfo registerInfo) {
        UserInfo userInfo = new UserInfo();
        BeanUtil.copyProperties(registerInfo, userInfo, "password");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(registerInfo.getPassword());
        userInfo.setPassword(encodePassword);
        userInfo.setUserId(generateStudentUserId(registerInfo).toString());
        userInfo.setActiveStatus(ActiveStatus.ACTIVE.getCode());
        Assert.isTrue(userInfoMapper.insertSelective(userInfo) == 1, "注册失败,请重试或联系管理员.");
        MatriculateStudent matriculateStudent = new MatriculateStudent();
        matriculateStudent.setIsRegistered((byte) 1);
        MatriculateStudentExample matriculateStudentExample = new MatriculateStudentExample();
        matriculateStudentExample.createCriteria().andIdCardEqualTo(userInfo.getIdCard()).andIsRegisteredEqualTo(IsRegistered.UNRegistered.getCode());
        Assert.isTrue(matriculateStudentMapper.updateByExampleSelective(matriculateStudent, matriculateStudentExample) == 1, "更新录取信息时出现错误,请联系管理员.");
        UserRoleLink userRoleLink = new UserRoleLink();
        userRoleLink.setUserId(userInfo.getUserId());
        userRoleLink.setRoleId(RoleEnum.STUDENT.getRoleId());
        Assert.isTrue(userRoleLinkMapper.insertSelective(userRoleLink) == 1, "关联用户角色信息时出现错误,请联系管理员.");
        return userInfo.getUserId();
    }

    private StringBuilder generateStudentUserId(RegisterInfo registerInfo) {
        String idCard = registerInfo.getIdCard();
        MatriculateStudentExample matriculateStudentExample = new MatriculateStudentExample();
        matriculateStudentExample.createCriteria().andIdCardEqualTo(idCard).andIsRegisteredEqualTo(IsRegistered.UNRegistered.getCode());
        List<MatriculateStudent> matriculateStudents = matriculateStudentMapper.selectByExample(matriculateStudentExample);
        Assert.isTrue(matriculateStudents.size() == 1, "您已注册或存在相同身份证用户,请尝试直接登录或联系管理员.");
        MatriculateStudent matriculateStudent = matriculateStudents.get(0);
        String graduateYear = matriculateStudent.getGraduateYear();
        String collegeId = matriculateStudent.getCollegeId().toString();
        String majorId = matriculateStudent.getMajorId().toString();
        String classId = matriculateStudent.getClassId().toString();
        String orderNum = matriculateStudent.getOrderNum().toString();
        StringBuilder userId = new StringBuilder();
        userId.append(graduateYear)
                .append(collegeId.length() > 1 ? collegeId : "0" + collegeId)
                .append(majorId.length() > 1 ? majorId : "0" + majorId)
                .append(classId.length() > 1 ? classId : "0" + classId)
                .append(orderNum.length() > 2 ? orderNum : orderNum.length() > 1 ? "0" + orderNum : "00" + orderNum);
        return userId;
    }

}
