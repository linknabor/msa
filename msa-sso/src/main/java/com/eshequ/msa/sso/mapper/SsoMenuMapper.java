package com.eshequ.msa.sso.mapper;

import com.eshequ.msa.sso.entity.SsoMenu;

public interface SsoMenuMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(SsoMenu record);

    int insertSelective(SsoMenu record);

    SsoMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SsoMenu record);

    int updateByPrimaryKey(SsoMenu record);
}