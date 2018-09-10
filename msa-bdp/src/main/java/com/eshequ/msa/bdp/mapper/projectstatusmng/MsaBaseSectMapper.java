package com.eshequ.msa.bdp.mapper.projectstatusmng;

import java.util.List;

import com.eshequ.msa.bdp.model.projectstatusmng.MsaBaseSect;
import com.eshequ.msa.bdp.vo.SectAndEnterpriseVo;
import com.eshequ.msa.common.CommonMapper;

public interface MsaBaseSectMapper extends CommonMapper<MsaBaseSect>{
	List<SectAndEnterpriseVo> getSectAndEnterpriseList(SectAndEnterpriseVo sectAndEnterpriseVo);
}
