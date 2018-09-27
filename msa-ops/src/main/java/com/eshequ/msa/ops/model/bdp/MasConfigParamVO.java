package com.eshequ.msa.ops.model.bdp;

public class MasConfigParamVO {
	private Long paraId;
	private String name;
	private String value;
	private String remark;
	
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getParaId() {
		return paraId;
	}
	public void setParaId(Long paraId) {
		this.paraId = paraId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
