package com.eshequ.msa.ops.service.msareginfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.eshequ.msa.ops.model.msareginfo.MsaRegInfo;
import com.eshequ.msa.ops.model.msareginfo.MsaSmsSum;

public interface MsaRegInfoService {
	// 添加企业注册信息
	int addMsaInfo(MsaRegInfo masRegInfo);

	// 导入excel文件保存信息
	Map<String, String> importData(MultipartFile file) throws IOException;

	// 根据导入批次号发送短信
	Map<String, Object> sendSms(String importBatchs);

	// 根据日期查询短信信息
	List<MsaSmsSum> findMsaSmsSum(String date);

}
