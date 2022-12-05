package com.totoropcbeta.studentmanagesystem.service.impl;

import com.totoropcbeta.studentmanagesystem.bo.PermissionInfoBO;
import com.totoropcbeta.studentmanagesystem.mapper.PermissionInfoMapper;
import com.totoropcbeta.studentmanagesystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanhang08
 * @date 2022年12月05日
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionInfoMapper permissionInfoMapper;

    @Override
    public List<PermissionInfoBO> listPermissionInfoBO() {
        List<PermissionInfoBO> permissionInfoBOS = permissionInfoMapper.listPermissionInfoBO();
        return permissionInfoBOS;
    }
}
