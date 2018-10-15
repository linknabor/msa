package com.eshequ.msa.ops.web.msasmsmng;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.msasmsmng.MsaSmsSum;
import com.eshequ.msa.ops.service.msasmsmng.MsaSmsMngService;
import com.eshequ.msa.ops.web.BaseController;
import com.eshequ.msa.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class MsaSmsMngController extends BaseController{
	@Autowired
	private MsaSmsMngService msaRegInfoService;



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
