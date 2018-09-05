package com.eshequ.msa.ops.web.msareginfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.msareginfo.MsaRegInfo;
import com.eshequ.msa.ops.model.msareginfo.MsaSmsSum;
import com.eshequ.msa.ops.service.msareginfo.MsaRegInfoService;
import com.eshequ.msa.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class MsaRegInfoController {
	@Autowired
	private MsaRegInfoService msaRegInfoService;

	@RequestMapping(value = "/addOrUpdateMsaInfo", method = RequestMethod.POST)
	public BaseResult<?> addOrUpdateMsaInfo(MsaRegInfo msaRegInfo,String type,HttpSession session) {
		if (msaRegInfo != null) {
			if(ObjectUtil.isEmpty(msaRegInfo.getRegEnterpriseId())){
				return msaRegInfoService.addMsaInfo(msaRegInfo);
			}else{
				return msaRegInfoService.updateMsaInfo(msaRegInfo,type);
			}
		}
		return BaseResult.fail(500,"参数错误！");
	}
	
	@RequestMapping(value = "/getMsaInfoById", method = RequestMethod.GET)
    public  MsaRegInfo  getMsaInfoById(String regEnterpriseId){
		return msaRegInfoService.getMsaInfoById(regEnterpriseId);
    }
	
	@RequestMapping(value = "/getMsaInfoList", method = RequestMethod.GET)
	public PageInfo<MsaRegInfo> getMsaInfoList(@RequestParam(defaultValue = "0", required = false) int pageNum,
			@RequestParam(defaultValue = "10", required = false) int pageSize, MsaRegInfo msaRegInfo) {
		PageHelper.startPage(pageNum, pageSize);
		List<MsaRegInfo> lists = msaRegInfoService.getMsaInfoList(msaRegInfo);
		PageInfo<MsaRegInfo> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	
	@RequestMapping(value = "/importData", method = RequestMethod.POST)
	public BaseResult<?> importData(MultipartFile file) throws IOException {
		if (file != null) {
			return msaRegInfoService.importData(file);
		}
		return BaseResult.fail(500, "参数错误！");
	}

	@RequestMapping(value = "/sendSms", method = RequestMethod.POST)
	public BaseResult<?> sendSms(String importBatchs) {
		if (!ObjectUtil.isEmpty(importBatchs)) {
			return msaRegInfoService.sendSms(importBatchs);
		}
		return BaseResult.fail(500, "参数错误！");

	}

	@RequestMapping(value = "/findMsaSmsSum", method = RequestMethod.GET)
	public PageInfo<MsaSmsSum> findMsaSmsSum(@RequestParam(defaultValue = "0", required = false) int pageNum,
			@RequestParam(defaultValue = "10", required = false) int pageSize, String date) {
		PageHelper.startPage(pageNum, pageSize);
		List<MsaSmsSum> lists = msaRegInfoService.findMsaSmsSum(date);
		PageInfo<MsaSmsSum> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

}
