package com.eshequ.msa.ops.service.projectstatusmng.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.service.projectstatusmng.ProjectStatusMngService;
import com.eshequ.msa.ops.vo.SectAndEnterpriseVo;
import com.eshequ.msa.util.http.HttpClientProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ProjectStatusMngServiceImpl implements ProjectStatusMngService {
	private static final Logger logger = LoggerFactory.getLogger(ProjectStatusMngServiceImpl.class);
	
	@Autowired
	private HttpClientProxy httpClientProxy;
	
	@Value("${bdp.SectAndEnterpriseListUrl}")
	private String listUrl;
	@Override
	public BaseResult<?> updateMasBaseSect(MsaBaseSect masBaseSect) {
		return null;
	}
	@Override
	public String getSectAndEnterpriseList(int pageNum, int pageSize, SectAndEnterpriseVo sectAndEnterpriseVo) {
		String response="";
		ObjectMapper mapper = new ObjectMapper(); 
		 try {
			String requestJsonStr = mapper.writeValueAsString(sectAndEnterpriseVo);
			 response=httpClientProxy.doPost(listUrl, requestJsonStr, "utf-8");
		 } catch (JsonProcessingException e) {
			logger.error(e.getMessage(),e);
		}
		return response;
	}

}
