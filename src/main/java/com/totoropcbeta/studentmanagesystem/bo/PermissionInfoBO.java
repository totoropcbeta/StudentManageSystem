package com.totoropcbeta.studentmanagesystem.bo;

import lombok.Data;

@Data
public class PermissionInfoBO {

    private String id;

    private String permissionName;

    private String permissionUri;

    private String permissionMethod;

    private String roleName;

    private String roleCode;
}
