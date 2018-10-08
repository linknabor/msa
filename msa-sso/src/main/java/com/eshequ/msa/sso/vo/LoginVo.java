package com.eshequ.msa.sso.vo;

/**
 * 用于登录 
 * 使用接口 /login
 * @author Jeffrey
 *
 */
public class LoginVo {
	private String reqUrl;
	private String userName;
	private String password;
	private String veriCode;
	private String tpSysName;
	public String getReqUrl() {
		return reqUrl;
	}
	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVeriCode() {
		return veriCode;
	}
	public void setVeriCode(String veriCode) {
		this.veriCode = veriCode;
	}
	public String getTpSysName() {
		return tpSysName;
	}
	public void setTpSysName(String tpSysName) {
		this.tpSysName = tpSysName;
	}
	@Override
	public String toString() {
		return "LoginVo [reqUrl=" + reqUrl + ", userName=" + userName + ", password=" + password + ", veriCode="
				+ veriCode + ", tpSysName=" + tpSysName + "]";
	}

	
	
}
