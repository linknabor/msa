package com.eshequ.msa.sso.service;

import java.util.List;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoRole;

public interface RoleService {
	/**
	 * 添加角色
	 * @param roleName 角色名
	 * @return
	 */
	BaseResult<?> addRole(String roleName);
	
	/**
	 * 保存角色(添加或修改)
	 * @param role 角色实体
	 * @return
	 */
	BaseResult<?> saveRole(SsoRole role);
	
	/**
	 * 删除角色
	 * @param roleId 角色id
	 * @return
	 */
	BaseResult<?> deleteRole(Long roleId);
	
	/**
	 * 根据角色id查询角色
	 * @param roleId 角色id
	 * @return
	 */
	SsoRole getRoleById(Long roleId);
	
	/**
	 * 获得全部角色
	 * @return
	 */
	List<SsoRole> getAllRole();
	
	/**
	 * 搜索角色
	 * @param roleId 角色id
	 * @param roleName 角色名称
	 * @return
	 */
	List<SsoRole> searchRole(Long roleId,String roleName);
}
