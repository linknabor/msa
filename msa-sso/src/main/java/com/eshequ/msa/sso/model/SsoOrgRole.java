package com.eshequ.msa.sso.model;

import com.eshequ.msa.common.BaseModel;

public class SsoOrgRole extends BaseModel {
    private Long orgId;

    private Long roleId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}