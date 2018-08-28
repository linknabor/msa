package com.eshequ.msa.crm.service.msareginfo;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.eshequ.msa.crm.model.msareginfo.MsaRegInfo;

public interface MsaRegInfoService {
	int addMsaInfo(MsaRegInfo masRegInfo);
	Map<String,String> importData(MultipartFile file) throws IOException;

}
