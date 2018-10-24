package com.eshequ.msa.crm.web.repairmng;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.crm.model.repairmng.RepairOrder;
import com.eshequ.msa.crm.service.repairmng.RepairOrderService;
import com.eshequ.msa.crm.util.QiYeWeiXinUtil;
import com.eshequ.msa.crm.vo.repairmng.RepairAndFileVo;
import com.eshequ.msa.crm.web.BaseController;

@RestController
@RequestMapping("/repairOder")
public class RepairOderController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(RepairOderController.class);
	
	@Autowired
	private RepairOrderService repairOrderService;
	
	@Autowired
	private QiYeWeiXinUtil qiYeWeiXinUtil;
	
	//获取报修订单列表
	@RequestMapping(value="/getRepairOrderList",method=RequestMethod.GET)
	public BaseResult<?> getRepairOrderList(){
		return BaseResult.successResult(repairOrderService.getRepairOrderList());
	} 
	
	//报修订单详情
	@RequestMapping(value="/getRepairOrderDetail",method=RequestMethod.GET)
	public BaseResult<?> getRepairOrderDetail(String repairId){
		return BaseResult.successResult(repairOrderService.getRepairOrderDetail(repairId));
	}
	
	//添加报修管理
	@RequestMapping(value="/addOrUpdateRepairOrder",method=RequestMethod.POST)
	public BaseResult<?> addOrUpdateRepairOrder(RepairAndFileVo repairAndFileVo){
		if(repairAndFileVo != null){
			if(repairAndFileVo.getRepairOrder().getRepairId() != null){
				return repairOrderService.updateRepairOrder(repairAndFileVo);
			}else{
				return repairOrderService.addRepairOrder(repairAndFileVo);
			}
		}
			return BaseResult.fail("参数为空！");
	}
	
	

}
