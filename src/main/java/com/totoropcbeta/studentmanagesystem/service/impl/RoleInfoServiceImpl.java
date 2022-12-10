package com.totoropcbeta.studentmanagesystem.service.impl;

import com.totoropcbeta.studentmanagesystem.entity.RoleInfo;
import com.totoropcbeta.studentmanagesystem.mapper.RoleInfoMapper;
import com.totoropcbeta.studentmanagesystem.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色信息服务实现类
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public List<RoleInfo> listRoleByUserId(String userId) {

        return roleInfoMapper.listRoleByUserId(userId);
    }
}
