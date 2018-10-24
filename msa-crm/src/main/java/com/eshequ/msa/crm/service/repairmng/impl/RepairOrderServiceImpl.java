package com.eshequ.msa.crm.service.repairmng.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.crm.mapper.repairmng.FileMngMapper;
import com.eshequ.msa.crm.mapper.repairmng.RepairOrderMapper;
import com.eshequ.msa.crm.model.repairmng.FileMng;
import com.eshequ.msa.crm.model.repairmng.RepairOrder;
import com.eshequ.msa.crm.model.repairmng.UserInfo;
import com.eshequ.msa.crm.service.repairmng.RepairOrderService;
import com.eshequ.msa.crm.vo.repairmng.RepairAndFileVo;
import com.eshequ.msa.util.SnowFlake;

@Service
@Transactional
public class RepairOrderServiceImpl implements RepairOrderService {
	private final String REPAIR_STATUS_UNASSINGED = "0"; // 未分配

	@Autowired
	private RepairOrderMapper repairOrderMapper;
	
	@Autowired
	private FileMngMapper fileMngMapper;

	@Autowired
	private SnowFlake snowFlake;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public List<RepairOrder> getRepairOrderList() {
		return repairOrderMapper.getRepairOrderList();
	}

	@Override
	public BaseResult<?> addRepairOrder(RepairAndFileVo repairAndFileVo) {
		String repairId = String.valueOf(snowFlake.nextId());
		RepairOrder repairOrder = repairAndFileVo.getRepairOrder();
		repairOrder.setRepairId(repairId);
		repairOrder.setRepairDate(new Date());
		repairOrder.setRepairStatus(REPAIR_STATUS_UNASSINGED);
		//添加当前人信息
	    UserInfo   user=(UserInfo) redisTemplate.opsForValue().get("user");
	    repairOrder.setRepairPepoleId(user.getUserid());
	    repairOrder.setRepairPepoleName(user.getName());
	    repairOrder.setRepairPepoleImg(user.getAvatar());
		int count = repairOrderMapper.insertSelective(repairOrder);
		if (count > 0) {
              for (FileMng fileMng : repairAndFileVo.getList()) {
            	  String fileId = String.valueOf(snowFlake.nextId());
            	  fileMng.setRepairId(repairId);
            	  fileMng.setCreateDate(new Date());
            	  fileMng.setFileId(fileId);
            	  fileMngMapper.insertSelective(fileMng);
			}
              
              return BaseResult.successResult("添加成功！");   
		}
		return BaseResult.fail("添加失败！");
	}
    
	@Override
	public BaseResult<?> updateRepairOrder(RepairAndFileVo repairAndFileVo) {
		int count = repairOrderMapper.updateByPrimaryKeySelective(repairAndFileVo.getRepairOrder());
		int result=fileMngMapper.seleteByRepairId(repairAndFileVo.getRepairOrder().getRepairId());
		if(count > 0 && result>0){
			if(repairAndFileVo.getList()!=null && repairAndFileVo.getList().size()>0 ){
				 for (FileMng fileMng : repairAndFileVo.getList()) {
					 String fileId = String.valueOf(snowFlake.nextId());
	            	  fileMng.setRepairId(repairAndFileVo.getRepairOrder().getRepairId());
	            	  fileMng.setCreateDate(new Date());
	            	  fileMng.setFileId(fileId);
	            	  fileMngMapper.insertSelective(fileMng);
				}
			}
		}
		return BaseResult.fail("编辑失败！");
	}

	@Override
	public RepairAndFileVo getRepairOrderDetail(String repairId) {
		RepairAndFileVo vo=new RepairAndFileVo();
		RepairOrder repairOrder=repairOrderMapper.findRepairOrderById(repairId);
		List<FileMng> fileList=fileMngMapper.getRepairOrderById(repairId);
		vo.setList(fileList);
		vo.setRepairOrder(repairOrder);
		return vo;
	}

}
