package com.eshequ.msa.bdp.service.projectstatusmng;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.vo.SectAndEnterpriseVo;
import com.eshequ.msa.common.BaseResult;

public interface ProjectStatusMngService {

	int updateMasBaseSect(MsaBaseSect masBaseSect);

	List<SectAndEnterpriseVo> getSectAndEnterpriseList(SectAndEnterpriseVo sectAndEnterpriseVo);

	BaseResult<?> getAllRegion();

}
