package com.totoropcbeta.studentmanagesystem.service;


import com.totoropcbeta.studentmanagesystem.entity.RoleInfo;

import java.util.List;

/**
 * 角色信息服务类
 */
public interface RoleInfoService {

    List<RoleInfo> listRoleByUserId(String userId);

}
