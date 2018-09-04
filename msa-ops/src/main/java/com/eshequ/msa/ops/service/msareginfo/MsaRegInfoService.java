package com.eshequ.msa.ops.service.msareginfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.msareginfo.MsaRegInfo;
import com.eshequ.msa.ops.model.msareginfo.MsaSmsSum;

public interface MsaRegInfoService {
	// 添加企业注册信息
	BaseResult<?> addMsaInfo(MsaRegInfo masRegInfo);

	// 导入excel文件保存信息
	BaseResult<?> importData(MultipartFile file) throws IOException;

	// 根据导入批次号发送短信
	BaseResult<?> sendSms(String importBatchs);

	// 根据日期查询短信信息
	List<MsaSmsSum> findMsaSmsSum(String date);

}
