package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.crm.entity.SsoRole;

public interface SsoRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SsoRole record);

    int insertSelective(SsoRole record);

    SsoRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SsoRole record);

    int updateByPrimaryKey(SsoRole record);
}