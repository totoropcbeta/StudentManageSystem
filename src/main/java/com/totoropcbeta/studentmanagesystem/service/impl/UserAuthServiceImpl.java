package com.totoropcbeta.studentmanagesystem.service.impl;

import com.totoropcbeta.studentmanagesystem.bo.AccessToken;
import com.totoropcbeta.studentmanagesystem.bo.UserDetail;
import com.totoropcbeta.studentmanagesystem.cache.Cache;
import com.totoropcbeta.studentmanagesystem.enums.CacheName;
import com.totoropcbeta.studentmanagesystem.provider.AuthProvider;
import com.totoropcbeta.studentmanagesystem.provider.JwtProvider;
import com.totoropcbeta.studentmanagesystem.service.UserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    }

    @Override
    public AccessToken refreshToken(String token) {
        AccessToken accessToken = jwtProvider.refreshToken(token);
        UserDetail userDetail = caffeineCache.get(CacheName.USER, accessToken.getUserId(), UserDetail.class);
        caffeineCache.put(CacheName.USER, accessToken.getUserId(), userDetail);
        return accessToken;
    }
}
