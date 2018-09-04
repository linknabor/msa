package com.eshequ.msa.ops.service.msareginfo.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.exception.BusinessException;
import com.eshequ.msa.ops.mapper.msareginfo.MsaRegInfoMapper;
import com.eshequ.msa.ops.mapper.msareginfo.MsaSmsInfoMapper;
import com.eshequ.msa.ops.mapper.msareginfo.MsaSmsSumMapper;
import com.eshequ.msa.ops.mapper.msareginfo.OpsArrearageInfoMapper;
import com.eshequ.msa.ops.model.msareginfo.MsaRegInfo;
import com.eshequ.msa.ops.model.msareginfo.MsaSmsInfo;
import com.eshequ.msa.ops.model.msareginfo.MsaSmsSum;
import com.eshequ.msa.ops.model.msareginfo.OpsArrearageInfo;
import com.eshequ.msa.ops.service.msareginfo.MsaRegInfoService;
import com.eshequ.msa.util.DateUtil;
import com.eshequ.msa.util.SmsUtil;
import com.eshequ.msa.util.SnowFlake;

@Service
@Transactional
public class MsaRegInfoImpl implements MsaRegInfoService {
	private final String FAILED_STATUS = "1";
	private final String SUCCESS_STATUS = "0";
	@Autowired
	private MsaRegInfoMapper msaRegInfoMapper;

	@Autowired
	private OpsArrearageInfoMapper opsArrearageInfoMapper;

	@Autowired
	private MsaSmsInfoMapper msaSmsInfoMapper;

	@Autowired
	private MsaSmsSumMapper msaSmsSumMapper;

	@Autowired
	private SnowFlake snowFlake;

	@Autowired
	private SmsUtil smsUtil;

	@Override
	public BaseResult<?> addMsaInfo(MsaRegInfo MasRegInfo) {
		MasRegInfo.setRegEnterpriseId(String.valueOf(snowFlake.nextId()));
		MasRegInfo.setRegDate(DateUtil.getSysDate());
		MasRegInfo.setRegTime(DateUtil.getSysTime());
		// MasRegInfo.setBackTeName(backTeName);
		MasRegInfo.setStatus(InfoStatus.ZhengChang.toString());
		if(msaRegInfoMapper.insertSelective(MasRegInfo)>0){
			return BaseResult.successResult("注册成功！");
		}
		return BaseResult.fail(0, "注册失败！");
	}

	@Override
	public BaseResult<?> importData(MultipartFile file) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		DecimalFormat df = new DecimalFormat("#");
		long importBatch = snowFlake.nextId();
		String importDate = DateUtil.getSysDate();
		String importTime = DateUtil.getSysTime();
		if ("xls".equalsIgnoreCase(suffix)) {
			HSSFWorkbook hssf = new HSSFWorkbook(file.getInputStream());
			HSSFSheet sheet = hssf.getSheetAt(0);
			HSSFRow firstRow = sheet.getRow(0);
			if (firstRow.getPhysicalNumberOfCells() != 3) {
				throw new BusinessException(0, "导入数据表头列数不正确！");
			} else {
				int totalRows = sheet.getLastRowNum();
				OpsArrearageInfo oai = new OpsArrearageInfo();
				for (int i = 1; i <= totalRows; i++) {
					oai.setArrearageInfo(snowFlake.nextId());
					oai.setImportDate(importDate);
					oai.setImportTime(importTime);
					oai.setImportBatch(importBatch);
					HSSFRow row = sheet.getRow(i);
					HSSFCell cell = row.getCell(0);
					if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						throw new BusinessException(0, "第" + i + "行数据：" + "地址为空！");
					} else {
						oai.setCustAddr(cell.getStringCellValue());
					}
					cell = row.getCell(1);
					if (cell != null) {
						if (cell.getCellType() != HSSFCell.CELL_TYPE_NUMERIC) {
							throw new BusinessException(0, "第" + i + "行数据：" + "欠款金额类型不正确！");
						} else {
							oai.setArrearageAmt(new BigDecimal(cell.getNumericCellValue()));
						}
					} else {
						throw new BusinessException(0, "第" + i + "行数据：" + "欠款金额为空！");
					}

					cell = row.getCell(2);
					if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						throw new BusinessException(0, "第" + i + "行数据：" + "手机号为空！");
					} else {
						oai.setMobile(df.format(cell.getNumericCellValue()).toString());
					}
					opsArrearageInfoMapper.insertSelective(oai);
				}
				map.put("count", String.valueOf(totalRows));
				map.put("importBatch", String.valueOf(importBatch));
			}

		} else if ("xlsx".equalsIgnoreCase(suffix)) {
			XSSFWorkbook xssf = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = xssf.getSheetAt(0);
			XSSFRow firstRow = sheet.getRow(0);
			if (firstRow.getPhysicalNumberOfCells() != 3) {
				throw new BusinessException(0,"导入数据表头列数不正确！");
			} else {
				int totalRows = sheet.getLastRowNum();
				OpsArrearageInfo oai = new OpsArrearageInfo();
				for (int i = 1; i <= totalRows; i++) {
					oai.setArrearageInfo(snowFlake.nextId());
					oai.setImportDate(importDate);
					oai.setImportTime(importTime);
					oai.setImportBatch(importBatch);
					XSSFRow row = sheet.getRow(i);
					XSSFCell cell = row.getCell(0);
					if (cell == null || cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
						throw new BusinessException(0,"第" + i + "行数据：" + "地址为空！");
					} else {
						oai.setCustAddr(cell.getStringCellValue());
					}
					cell = row.getCell(1);
					if (cell != null) {
						if (cell.getCellType() != XSSFCell.CELL_TYPE_NUMERIC) {
							throw new BusinessException(0, "第" + i + "行数据：" + "欠款金额类型不正确！");
						} else {
							oai.setArrearageAmt(new BigDecimal(cell.getNumericCellValue()));
						}
					} else {
						throw new BusinessException(0,  "第" + i + "行数据：" + "欠款金额为空！");
					}
					cell = row.getCell(2);
					if (cell == null || cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
						throw new BusinessException(0, "第" + i + "行数据：" + "手机号为空！");
					} else {

						oai.setMobile(df.format(cell.getNumericCellValue()).toString());
					}
					opsArrearageInfoMapper.insertSelective(oai);
				}
				map.put("count", String.valueOf(totalRows));
				map.put("importBatch", String.valueOf(importBatch));
			}
		}
		return BaseResult.successResult(map);
	}

	@Override
	public BaseResult<?> sendSms(String importBatchs) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] array = importBatchs.split(",");
		List<OpsArrearageInfo> mobileList = opsArrearageInfoMapper.findMobileByImpotBatchs(array);
		// 统计短信失败数量
		int count = 0;
		long smsBatch = snowFlake.nextId();
		for (int i = 0; i < mobileList.size(); i++) {
			String mobile = mobileList.get(i).getMobile();
			String message = "【合协社区】" + "尊敬的业主，这里是合协社区微信公众平台，您名下" + mobileList.get(i).getCustAddr() + "住房有未缴物业费，总金额为："
					+ mobileList.get(i).getArrearageAmt() + "元，" + "我们会在七个工作日内给您发送书面清单，请注意查收。合协社区将为您解决欠费问题，提供友善的服务。";
			Map<String, String> SmsMap = new HashMap<>();
			SmsMap.put("mobile", mobile);
			SmsMap.put("msg", message);
			boolean ret = smsUtil.send(SmsMap);
			MsaSmsInfo msi = new MsaSmsInfo();
			msi.setContent(message);
			msi.setSmsId(snowFlake.nextId());
			msi.setSendDate(DateUtil.getSysDate());
			msi.setSendTime(DateUtil.getSysTime());
			msi.setSmsBatch(smsBatch);
			msi.setMobile(mobile);
			if (ret == false) {
				msi.setSmsStatus(FAILED_STATUS);
				count++;
			} else {
				msi.setSmsStatus(SUCCESS_STATUS);
			}
			msaSmsInfoMapper.insertSelective(msi);
		}
		// todo 保存发送短信数量，失败数量
		MsaSmsSum mss = new MsaSmsSum();
		mss.setSendDate(DateUtil.getSysDate());
		mss.setSendTime(DateUtil.getSysTime());
		mss.setSmsBatch(smsBatch);
		;
		mss.setTotalCount(new BigDecimal(mobileList.size()));
		mss.setTotalFailed(new BigDecimal(count));
		msaSmsSumMapper.insertSelective(mss);
		map.put("failedCount", count);
		map.put("totalCount", mobileList.size());
		return BaseResult.successResult(map);
	}

	@Override
	public List<MsaSmsSum> findMsaSmsSum(String date) {

		return msaSmsSumMapper.findMsaSmsByDate(date);
	}
}
