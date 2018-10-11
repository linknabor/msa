package com.eshequ.msa.ops.web.projectstatusmng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.service.projectstatusmng.BdpSectAndEnterpriseRemote;
import com.eshequ.msa.ops.vo.projectstatusmng.SectAndEnterpriseVo;

@RestController
@RequestMapping("/projectStatusMng")
public class ProjectStatusMngController {
	 @Autowired
     private BdpSectAndEnterpriseRemote bdpSectAndEnterpriseRemote;
	
	@RequestMapping(value="/getMsaBaseSectList",method=RequestMethod.GET)
	public BaseResult<?> getMsaBaseSectList(@RequestParam(defaultValue = "0", required = false) int pageNum,
			@RequestParam(defaultValue = "10", required = false) int pageSize,@RequestBody SectAndEnterpriseVo sectAndEnterpriseVo){
		return bdpSectAndEnterpriseRemote.getSectAndEnterpriseList(pageNum, pageSize, sectAndEnterpriseVo);
	}
	@RequestMapping(value="/addOrUpdateMasBaseSect",method=RequestMethod.POST)
	public BaseResult<?> addOrUpdateMasBaseSect(@RequestBody MsaBaseSect masBaseSect){
		if(masBaseSect != null){
			if(masBaseSect.getSectId() != null){
			int count=bdpSectAndEnterpriseRemote.updateMasBaseSect(masBaseSect);
			if(count>0){
				if(count==2){
					return BaseResult.fail("网络连接异常,请重试！");
				}
				return BaseResult.successResult("保存成功！");
			}
			return BaseResult.fail(0, "保存失败！");
			}
		}
		return BaseResult.fail(500, "参数错误！");
	}
}
