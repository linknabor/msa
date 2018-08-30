package com.eshequ.msa.sso.mapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.sso.model.SsoMenu;

public interface SsoMenuMapper extends CommonMapper<SsoMenu>{
	/**
	 * 修改菜单
	 * @param menu 菜单实体
	 * @return
	 */
	int updateSsoMenu(SsoMenu menu);
    
}