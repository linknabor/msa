package com.eshequ.msa.sso.vo;

/**
 * 用于给用户添加权限
 * 使用接口 /menu/saveRoleMenuByRoleId
 * @author Jeffrey
 *
 */
public class RoleMenuVo {
	private Long[] menuIdArray;
	private Long roleId;
	public Long[] getMenuIdArray() {
		return menuIdArray;
	}
	public void setMenuIdArray(Long[] menuIdArray) {
		this.menuIdArray = menuIdArray;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
}
