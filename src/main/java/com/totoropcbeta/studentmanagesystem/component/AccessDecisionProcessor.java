package com.totoropcbeta.studentmanagesystem.component;

import com.totoropcbeta.studentmanagesystem.bo.PermissionInfoBO;
import com.totoropcbeta.studentmanagesystem.bo.UserDetail;
import com.totoropcbeta.studentmanagesystem.cache.Cache;
import com.totoropcbeta.studentmanagesystem.enums.CacheName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Slf4j
public class AccessDecisionProcessor implements AccessDecisionVoter<FilterInvocation> {
    @Resource
    private Cache caffeineCache;

    @Override
    public int vote(Authentication authentication, FilterInvocation object, Collection<ConfigAttribute> attributes) {
        assert authentication != null;
        assert object != null;

        // 拿到当前请求uri
        String requestUrl = object.getRequestUrl();
        String method = object.getRequest().getMethod();
        log.debug("进入自定义鉴权投票器, URI : {} {}", method, requestUrl);

        String key = requestUrl + ":" + method;
        // 如果没有缓存中没有此权限也就是未保护此API, 弃权
        PermissionInfoBO permission = caffeineCache.get(CacheName.PERMISSION, key, PermissionInfoBO.class);
        if (permission == null) {
            return ACCESS_ABSTAIN;
        }

        // 拿到当前用户所具有的权限
        List<String> roles = ((UserDetail) authentication.getPrincipal()).getRoles();
        if (roles.contains(permission.getRoleCode())) {
            return ACCESS_GRANTED;
        } else {
            return ACCESS_DENIED;
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
