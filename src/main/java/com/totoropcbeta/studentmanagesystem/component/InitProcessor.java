package com.totoropcbeta.studentmanagesystem.component;


import com.totoropcbeta.studentmanagesystem.bo.PermissionInfoBO;
import com.totoropcbeta.studentmanagesystem.cache.Cache;
import com.totoropcbeta.studentmanagesystem.enums.CacheName;
import com.totoropcbeta.studentmanagesystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitProcessor {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private Cache caffeineCache;

    @PostConstruct
    public void init() {
        List<PermissionInfoBO> permissionInfoList = permissionService.listPermissionInfoBO();
        permissionInfoList.forEach(permissionInfo -> {
            caffeineCache.put(CacheName.PERMISSION, permissionInfo.getPermissionUri() + ":" + permissionInfo.getPermissionMethod(), permissionInfo);
        });
    }
}
