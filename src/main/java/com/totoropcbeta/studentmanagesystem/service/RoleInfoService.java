package com.totoropcbeta.studentmanagesystem.service;


import com.totoropcbeta.studentmanagesystem.entity.RoleInfo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 和耳朵
 * @since 2020-06-30
 */
public interface RoleInfoService {

    List<RoleInfo> listRoleByUserId(Integer userId);

}
