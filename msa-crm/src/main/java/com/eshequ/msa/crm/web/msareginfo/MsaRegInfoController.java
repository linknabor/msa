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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eshequ.msa.crm.model.msareginfo.MsaRegInfo;
import com.eshequ.msa.crm.service.msareginfo.MsaRegInfoService;

@RestController
public class MsaRegInfoController {
	@Autowired
	private MsaRegInfoService msaRegInfoService;
	
	@RequestMapping(value="/addMsaInfo",method=RequestMethod.POST)
	public int addMsaInfo(@RequestBody MsaRegInfo msaRegInfo){
		if(msaRegInfo != null){
			return msaRegInfoService.addMsaInfo(msaRegInfo);
		}
		return 0;
	}
	
	@RequestMapping(value="/importData")
	public Map<String,String> importData(MultipartFile file) throws IOException{
		return msaRegInfoService.importData(file);
	         }

}
