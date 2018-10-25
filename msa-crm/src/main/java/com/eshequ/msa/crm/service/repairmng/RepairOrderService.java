package com.eshequ.msa.crm.service.repairmng;

import java.util.List;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.crm.model.repairmng.RepairAssign;
import com.eshequ.msa.crm.model.repairmng.RepairOrder;
import com.eshequ.msa.crm.vo.repairmng.RepairAndFileVo;

public interface RepairOrderService {
    
	List<RepairOrder> getRepairOrderList(String userId);

	BaseResult<?> updateRepairOrder(RepairAndFileVo repairAndFileVo);

	BaseResult<?> addRepairOrder(RepairAndFileVo repairAndFileVo);

	RepairAndFileVo getRepairOrderDetail(String repairId);

	int getNotLookOrderCount();

	String getMaxTime();

	int updateIsLook();
	
	int updateIsLookById(String repairId);

	BaseResult<?> getuserListByDepartMent();

	BaseResult<?> closeRepairOrder(RepairOrder repairOrder);

	BaseResult<?> addRepairAssignPepole(RepairAssign repairAssign,String repairId);

	BaseResult<?> repairOrderSuccess(String repairId);

}
