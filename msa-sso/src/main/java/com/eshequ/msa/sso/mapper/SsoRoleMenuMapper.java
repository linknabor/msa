package com.eshequ.msa.sso.mapper;

import com.eshequ.msa.sso.entity.SsoRoleMenu;

public interface SsoRoleMenuMapper {
    int deleteByPrimaryKey(SsoRoleMenu key);

    int insert(SsoRoleMenu record);

    int insertSelective(SsoRoleMenu record);
}