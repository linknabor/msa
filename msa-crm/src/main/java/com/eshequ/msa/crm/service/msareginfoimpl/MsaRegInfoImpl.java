package com.eshequ.msa.crm.service.msareginfoimpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.eshequ.msa.codes.InfoStatus;
import com.eshequ.msa.crm.mapper.msareginfo.MsaRegInfoMapper;
import com.eshequ.msa.crm.mapper.msareginfo.OpsArrearageInfoMapper;
import com.eshequ.msa.crm.model.msareginfo.MsaRegInfo;
import com.eshequ.msa.crm.model.msareginfo.OpsArrearageInfo;
import com.eshequ.msa.crm.service.msareginfo.MsaRegInfoService;
import com.eshequ.msa.util.DateUtil;
import com.eshequ.msa.util.SnowFlake;
@Service
@Transactional
public class MsaRegInfoImpl implements MsaRegInfoService {
	@Autowired
	private MsaRegInfoMapper msaRegInfoMapper;
	@Autowired
	private OpsArrearageInfoMapper opsArrearageInfoMapper;
	
	@Autowired
	private SnowFlake snowFlake;

	@Override
	public int addMsaInfo(MsaRegInfo MasRegInfo) {
		MasRegInfo.setRegEnterpriseId(String.valueOf(snowFlake.nextId()));
		MasRegInfo.setRegDate(DateUtil.getSysDate());
		MasRegInfo.setRegTime(DateUtil.getSysTime());
		//MasRegInfo.setBackTeName(backTeName);
		//System.out.println(InfoStatus.ZhengChang);
		//MasRegInfo.setStatus(InfoStatus.ZhengChang.toString());
		MasRegInfo.setStatus("1");
		return msaRegInfoMapper.insertSelective(MasRegInfo);
	}

	@Override
	public Map<String, String> importData(MultipartFile file) throws IOException {
		Map<String,String> map=new HashMap<String,String>();
		   String fileName=file.getOriginalFilename();
	         String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
	        // List<List<Object>> dataList=new ArrayList<>();
	         DecimalFormat df = new DecimalFormat("#");
	         long importBatch=snowFlake.nextId();
	         String importDate=DateUtil.getSysDate();
	         String importTime=DateUtil.getSysTime();
	         if("xls".equalsIgnoreCase(suffix)){
	             HSSFWorkbook hssf=new HSSFWorkbook();
	             HSSFSheet sheet=hssf.getSheetAt(0);
	             HSSFRow firstRow= sheet.getRow(0);
	             if(firstRow.getPhysicalNumberOfCells()!=3){
	            	map.put("status", "0");
	            	map.put("message", "导入数据表头列数不正确！");
	            	 return map;
	             }else{
	                 int totalRows=sheet.getLastRowNum();
	                 for(int i=1;i<=totalRows;i++){
	                	 OpsArrearageInfo oai=new OpsArrearageInfo();
	                	 oai.setArrearageInfo(snowFlake.nextId());
	                	 oai.setImportDate(importDate);
	                	 oai.setImportTime(importTime);
	                	 oai.setImportBatch(importBatch);
	                     List<Object> obj=new ArrayList<>();
	                     HSSFRow row= sheet.getRow(i);
	                     HSSFCell cell=row.getCell(0);
	                     if(cell==null || cell.getCellType()==HSSFCell.CELL_TYPE_BLANK){
	                    	 map.put("status", "0");
	                    	 map.put("message", "第"+i+"行数据："+"地址为空！");
	                    	 return map;
	                     }else{
	                    	 //obj.add(cell.getStringCellValue());
	                    	 oai.setCustAddr(cell.getStringCellValue());
	                     }
	                     cell=row.getCell(1);
	                     if(cell!=null){
	                    	 if(cell.getCellType()!=HSSFCell.CELL_TYPE_NUMERIC){
		                    	 map.put("status", "0");
		                    	 map.put("message", "第"+i+"行数据："+"欠款金额类型不正确！");
		                    	 return map;
		                     }else{
		                    	 //obj.add(cell.getNumericCellValue()); 
		                    	 oai.setArrearageAmt(new BigDecimal(cell.getNumericCellValue()));
		                     } 
	                     }else{
	                    	 map.put("status", "0");
	                    	 map.put("message", "第"+i+"行数据："+"欠款金额为空！");
	                    	 return map;
	                     }
	                     
	                     cell=row.getCell(2);
	                     if(cell==null || cell.getCellType()==HSSFCell.CELL_TYPE_BLANK){
	                    	 map.put("status", "0");
	                    	 map.put("message", "第"+i+"行数据："+"手机号为空！");
	                    	 return map;
	                     }else{
	                    	// obj.add(cell.getStringCellValue());
	                    	// oai.setMobile(cell.getStringCellValue()); 
	                    	 oai.setMobile(df.format(cell.getNumericCellValue()).toString());
	                     }
	                    // dataList.add(obj);
	                     opsArrearageInfoMapper.insertSelective(oai);
	                 }
	                 map.put("status", "1");
	                 map.put("message", "保存成功！");
	                 map.put("count", String.valueOf(totalRows));
	             }

	         }else if("xlsx".equalsIgnoreCase(suffix)){
	            XSSFWorkbook xssf=new XSSFWorkbook(file.getInputStream());
	            XSSFSheet  sheet= xssf.getSheetAt(0);
	            XSSFRow  firstRow= sheet.getRow(0);
	        int a=    firstRow.getPhysicalNumberOfCells();
	            if(firstRow.getPhysicalNumberOfCells()!=3){
	            	map.put("status", "0");
	            	map.put("message", "导入数据表头列数不正确！");
	            	 return map;
	             }else{
	                 int totalRows=sheet.getLastRowNum();
	                 for(int i=1;i<=totalRows;i++){
	                	 OpsArrearageInfo oai=new OpsArrearageInfo();
	                	 oai.setArrearageInfo(snowFlake.nextId());
	                	 oai.setImportDate(importDate);
	                	 oai.setImportTime(importTime);
	                	 oai.setImportBatch(importBatch);
	                     List<Object> obj=new ArrayList<>();
	                     XSSFRow row= sheet.getRow(i);
	                     XSSFCell cell =  row.getCell(0);
	                     if(cell==null || cell.getCellType()==XSSFCell.CELL_TYPE_BLANK){
	                    	 map.put("status", "0");
	                    	 map.put("message", "第"+i+"行数据："+"地址为空！");
	                    	 return map;
	                     }else{
	                    	// obj.add(cell.getStringCellValue());
	                    	 oai.setCustAddr(cell.getStringCellValue());
	                     }
	                     cell=row.getCell(1);
	                     if(cell !=null){
	                    	 if(cell.getCellType()!=XSSFCell.CELL_TYPE_NUMERIC){
		                    	 map.put("status", "0");
		                    	 map.put("message", "第"+i+"行数据："+"欠款金额类型不正确！");
		                    	 return map;
		                     }else{
		                    	 //obj.add(cell.getNumericCellValue()); 
		                    	 oai.setArrearageAmt(new BigDecimal(cell.getNumericCellValue()));
		                     } 
	                     }else{
	                    	 map.put("status", "0");
	                    	 map.put("message", "第"+i+"行数据："+"欠款金额为空！");
	                    	 return map; 
	                     }
	                     cell=row.getCell(2);
	                     if(cell==null || cell.getCellType()==XSSFCell.CELL_TYPE_BLANK){
	                    	 map.put("status", "0");
	                    	 map.put("message", "第"+i+"行数据："+"手机号为空！");
	                    	 return map;
	                     }else {

	                    	// obj.add(cell.getStringCellValue());
	                    	// oai.setMobile(cell.getStringCellValue()); 
	                    	 oai.setMobile(df.format(cell.getNumericCellValue()).toString());
	                     }
	                    // dataList.add(obj);
	                     opsArrearageInfoMapper.insertSelective(oai);
	                 }
	                 map.put("status", "1");
	                 map.put("message", "导入成功！");
	                 map.put("count", String.valueOf(totalRows));
	             }
	         }
			return map;
	}
}
