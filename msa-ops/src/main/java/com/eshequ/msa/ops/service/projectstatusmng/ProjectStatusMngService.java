package com.eshequ.msa.ops.service.projectstatusmng;


import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.vo.SectAndEnterpriseVo;
public interface ProjectStatusMngService {
	BaseResult<?> updateMasBaseSect(MsaBaseSect masBaseSect);

	String getSectAndEnterpriseList(int pageNum, int pageSize, SectAndEnterpriseVo sectAndEnterpriseVo);

}
