package com.totoropcbeta.studentmanagesystem.service.impl;

import com.totoropcbeta.studentmanagesystem.entity.RoleInfo;
import com.totoropcbeta.studentmanagesystem.mapper.RoleInfoMapper;
import com.totoropcbeta.studentmanagesystem.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 和耳朵
 * @since 2020-06-30
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public List<RoleInfo> listRoleByUserId(Integer userId) {

        return roleInfoMapper.listRoleByUserId(userId);
    }
}
