package com.eshequ.msa.ops.model.enterprisewechatmng;

import com.eshequ.msa.common.BaseModel;
import java.util.Date;

import javax.persistence.Id;

public class EnterpriseWechatMng extends BaseModel {
	@Id
    private Long userId;

    private String propertyCompany;

    private String neighbourhood;

    private Long roleId;

    private String roleName;

    private String enterpriseWechatName;

    private Long enterpriseWechatId;

    private Date createTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEnterpriseWechatName() {
        return enterpriseWechatName;
    }

    public void setEnterpriseWechatName(String enterpriseWechatName) {
        this.enterpriseWechatName = enterpriseWechatName;
    }

    public Long getEnterpriseWechatId() {
        return enterpriseWechatId;
    }

    public void setEnterpriseWechatId(Long enterpriseWechatId) {
        this.enterpriseWechatId = enterpriseWechatId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}