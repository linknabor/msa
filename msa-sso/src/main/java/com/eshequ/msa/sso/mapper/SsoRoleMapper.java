package com.eshequ.msa.sso.mapper;

import com.eshequ.msa.sso.entity.SsoRole;

public interface SsoRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SsoRole record);

    int insertSelective(SsoRole record);

    SsoRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SsoRole record);

    int updateByPrimaryKey(SsoRole record);
}