package com.eshequ.msa.crm.web.msareginfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eshequ.msa.crm.model.msareginfo.MsaRegInfo;
import com.eshequ.msa.crm.model.msareginfo.MsaSmsSum;
import com.eshequ.msa.crm.service.msareginfo.MsaRegInfoService;
import com.eshequ.msa.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class MsaRegInfoController {
	@Autowired
	private MsaRegInfoService msaRegInfoService;

	@RequestMapping(value = "/addMsaInfo", method = RequestMethod.POST)
	public int addMsaInfo(MsaRegInfo msaRegInfo) {
		if (msaRegInfo != null) {
			return msaRegInfoService.addMsaInfo(msaRegInfo);
		}
		return 0;
	}

	@RequestMapping(value = "/importData", method = RequestMethod.POST)
	public Map<String, String> importData(MultipartFile file) throws IOException {
		Map<String, String> map = new HashMap<>();
		if (file != null) {
			return msaRegInfoService.importData(file);
		}
		map.put("status", "0");
		map.put("message", "参数错误！");
		return map;
	}

	@RequestMapping(value = "/sendSms", method = RequestMethod.POST)
	public Map<String, Object> sendSms(String importBatchs) {
		Map<String, Object> map = new HashMap<>();
		if (!ObjectUtil.isEmpty(importBatchs)) {
			return msaRegInfoService.sendSms(importBatchs);
		}
		map.put("status", 0);
		map.put("message", "参数错误！");
		return map;

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
