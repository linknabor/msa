package com.eshequ.msa.crm.mapper.repairmng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.repairmng.RepairOrder;

public interface RepairOrderMapper extends CommonMapper<RepairOrder>{

	List<RepairOrder> getRepairOrderList(@Param("userId")String userId);

	RepairOrder findRepairOrderById(@Param("repairId")String repairId);

	int getNotLookOrderCount();
	
	String getMaxTime();

	int updateIsLook();

	int updateIsLookById(@Param("repairId")String repairId);

}
