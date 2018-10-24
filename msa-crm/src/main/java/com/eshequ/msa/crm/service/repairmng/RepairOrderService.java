package com.eshequ.msa.crm.service.repairmng;

import java.util.List;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.crm.model.repairmng.RepairOrder;
import com.eshequ.msa.crm.vo.repairmng.RepairAndFileVo;

public interface RepairOrderService {
    
	List<RepairOrder> getRepairOrderList();

	BaseResult<?> updateRepairOrder(RepairAndFileVo repairAndFileVo);

	BaseResult<?> addRepairOrder(RepairAndFileVo repairAndFileVo);

	RepairAndFileVo getRepairOrderDetail(String repairId);

}
