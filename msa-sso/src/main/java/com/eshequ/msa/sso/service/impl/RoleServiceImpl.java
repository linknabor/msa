package com.eshequ.msa.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.exception.BusinessException;
import com.eshequ.msa.handler.GlobalExceptionHandler;
import com.eshequ.msa.sso.mapper.SsoRoleMapper;
import com.eshequ.msa.sso.model.SsoRole;
import com.eshequ.msa.sso.service.RoleService;
import com.eshequ.msa.util.SnowFlake;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private SsoRoleMapper ssoRoleMapper;
	@Autowired
	private SnowFlake snowFlake;

	//添加角色
	@Override
	public BaseResult<?> addRole(String roleName) {
		SsoRole role = new SsoRole();
		role.setRoleName(roleName);
		//查询当前角色名是否存在
		int selectCount = ssoRoleMapper.selectCount(role);
		if(selectCount > 0) {
			return	BaseResult.fail(0, "角色名重复！");
		}	
		//添加角色
		role.setRoleId(snowFlake.nextId());
		int insertCount = ssoRoleMapper.insert(role);
		if(insertCount == 1) {
			return	BaseResult.successResult("添加角色成功！");
		}
		return BaseResult.fail(99,"添加角色错误！");
	}
	
	//保存角色(添加或修改)
	@Override
	public BaseResult<?> saveRole(SsoRole role,String type) {
		if(type.equals("0")) {
			// 查询当前角色名是否存在
			int selectCount = ssoRoleMapper.selectCount(role);
			if (selectCount > 0) {
				return BaseResult.fail(0, "角色名重复！");
			}
			// 添加角色
			role.setRoleId(snowFlake.nextId());
			int insertCount = ssoRoleMapper.insert(role);
			if (insertCount == 1) {
				return BaseResult.successResult("添加角色成功！");
			}
		}else {
			// 查询当前角色名是否存在
			SsoRole roleMapper = new SsoRole();
			roleMapper.setRoleName(role.getRoleName());
			int selectCount = ssoRoleMapper.selectCount(roleMapper);
			if (selectCount > 0) {
				return BaseResult.fail(0, "角色名重复！");
			}
			// 修改角色
			int updateCount = ssoRoleMapper.updateSsoRole(role);
			if (updateCount == 1) {
				return BaseResult.successResult("修改角色成功！");
			}
		}
		return BaseResult.fail(99, "操作角色错误！");
	}

	//删除角色
	@Override
	public BaseResult<?> deleteRole(Long roleId) {
		SsoRole role = new SsoRole();
		role.setRoleId(roleId);
		int deleteCount = ssoRoleMapper.delete(role);
		if(deleteCount > 0) {
			return BaseResult.successResult("删除角色成功！");
		}
		return BaseResult.fail(0,"当前角色不存在，删除失败！");
	}
	
	//根据角色id查询角色
	@Override
	public SsoRole getRoleById(Long roleId) {
		SsoRole ssoRole = new SsoRole();
		ssoRole.setRoleId(roleId);
		return ssoRoleMapper.selectOne(ssoRole);
	}

	//获得全部角色
	@Override
	public List<SsoRole> getAllRole() {
		List<SsoRole> list = ssoRoleMapper.selectAll();
		return list;
	}

	//搜索角色
	@Override
	public List<SsoRole> searchRole(Long roleId, String roleName,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return ssoRoleMapper.searchRole(roleId, roleName);
	}


}
