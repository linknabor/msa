package com.eshequ.msa.crm.web.repairmng;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.crm.model.repairmng.RepairAssign;
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
	
	
	//获取报修订单列表
	@RequestMapping(value="/getRepairOrderList",method=RequestMethod.GET)
	public BaseResult<?> getRepairOrderList(String userId){
		return BaseResult.successResult(repairOrderService.getRepairOrderList(userId));
	} 
	
	//报修订单详情
	@RequestMapping(value="/getRepairOrderDetail",method=RequestMethod.GET)
	public BaseResult<?> getRepairOrderDetail(String repairId){
		return BaseResult.successResult(repairOrderService.getRepairOrderDetail(repairId));
	}
	
	//添加报修管理
	@RequestMapping(value="/addOrUpdateRepairOrder",method=RequestMethod.POST)
	public BaseResult<?> addOrUpdateRepairOrder(@RequestBody RepairAndFileVo repairAndFileVo){
		if(repairAndFileVo != null){
			if(repairAndFileVo.getRepairOrder().getRepairId() != null){
				return repairOrderService.updateRepairOrder(repairAndFileVo);
			}else{
				return repairOrderService.addRepairOrder(repairAndFileVo);
			}
		}
			return BaseResult.fail("参数为空！");
	}
	//获取需要未查看的订单
	@RequestMapping(value="/getNotLookOrder",method=RequestMethod.GET)
	public BaseResult<?> getNotLookOrder(){
		int count=repairOrderService.getNotLookOrderCount();
		if(count > 0){
			String date=repairOrderService.getMaxTime();
			Map<String,String> map=new HashMap<>();
			map.put("count", String.valueOf(count));
			map.put("date", date);
			return BaseResult.successResult(map);
		}
			return BaseResult.fail("没有未查看的数据！");
	}
	
	//进入列表时讲状态改为已查看
	@RequestMapping(value="/updateIsLook",method=RequestMethod.GET)
	public BaseResult<?> updateIsLook(){
		    int count=repairOrderService.updateIsLook();
			return BaseResult.successResult("更改"+count+"条记录！");
	}
    
	//关闭报修订单
	@RequestMapping(value="/closeRepairOrder",method=RequestMethod.GET)
	public BaseResult<?> closeRepairOrder(RepairOrder repairOrder){
		
			return repairOrderService.closeRepairOrder(repairOrder);
	} 
	
	
	//获取部门所有成员详情
	@RequestMapping(value="/getuserListByDepartMent",method=RequestMethod.GET)
	public BaseResult<?> getuserListByDepartMent(){
		
			return repairOrderService.getuserListByDepartMent();
	}
	
	//添加维修人员
	@RequestMapping(value="/addRepairAssignPepole",method=RequestMethod.POST)
	public BaseResult<?> addRepairAssignPepole(@RequestBody RepairAssign repairAssign,String repairId){
		if(repairId != null){
			return repairOrderService.addRepairAssignPepole(repairAssign,repairId);
		}
		return BaseResult.fail("参数错误！");
	}
	
	//维修人员维修订单完工
	@RequestMapping(value="/repairOrderSuccess",method=RequestMethod.GET)
	public BaseResult<?> repairOrderSuccess(String repairId){
		
		return repairOrderService.repairOrderSuccess(repairId);
	}
	
	//测试上传文件
	@RequestMapping(value="/testFile",method=RequestMethod.GET)
	public BaseResult<?> testFile(String serverIds,String repairId ){
		repairOrderService.testFile(serverIds,repairId);
		return BaseResult.successResult("");
	}
	 
}
