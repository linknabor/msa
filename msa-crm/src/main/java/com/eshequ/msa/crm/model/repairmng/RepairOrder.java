package com.eshequ.msa.crm.model.repairmng;

import com.eshequ.msa.common.BaseModel;
import java.util.Date;

import javax.persistence.Id;

public class RepairOrder extends BaseModel {
	@Id
    private String repairId;

    private String repairType;

    private String repairAddress;

    private String repairContent;
    
    private String repairPhone;

    private Date repairDate;

    private String repairPepoleId;

    private String repairPepoleName;

    private String repairPepoleImg;

    private String repairStatus;

    private String repairCloseResion;

    private String repairAssignId;
    
    private String isLook;//是否查看 0未查看 1已查看

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getRepairAddress() {
        return repairAddress;
    }

    public void setRepairAddress(String repairAddress) {
        this.repairAddress = repairAddress;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }


    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairPepoleId() {
        return repairPepoleId;
    }

    public void setRepairPepoleId(String repairPepoleId) {
        this.repairPepoleId = repairPepoleId;
    }

    public String getRepairPepoleName() {
        return repairPepoleName;
    }

    public void setRepairPepoleName(String repairPepoleName) {
        this.repairPepoleName = repairPepoleName;
    }

    public String getRepairPepoleImg() {
        return repairPepoleImg;
    }

    public void setRepairPepoleImg(String repairPepoleImg) {
        this.repairPepoleImg = repairPepoleImg;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairCloseResion() {
        return repairCloseResion;
    }

    public void setRepairCloseResion(String repairCloseResion) {
        this.repairCloseResion = repairCloseResion;
    }

    public String getRepairAssignId() {
        return repairAssignId;
    }

    public void setRepairAssignId(String repairAssignId) {
        this.repairAssignId = repairAssignId;
    }

	public String getRepairPhone() {
		return repairPhone;
	}

	public void setRepairPhone(String repairPhone) {
		this.repairPhone = repairPhone;
	}

	public String getIsLook() {
		return isLook;
	}

	public void setIsLook(String isLook) {
		this.isLook = isLook;
	}
    
}