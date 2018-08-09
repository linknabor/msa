package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.crm.entity.SsoRoleMenu;

public interface SsoRoleMenuMapper {
    int deleteByPrimaryKey(SsoRoleMenu key);

    int insert(SsoRoleMenu record);

    int insertSelective(SsoRoleMenu record);
}