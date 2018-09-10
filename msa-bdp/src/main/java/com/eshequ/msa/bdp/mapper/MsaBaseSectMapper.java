package com.eshequ.msa.bdp.mapper;

import java.util.List;

import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.vo.SectAndEnterpriseVo;
import com.eshequ.msa.common.CommonMapper;

public interface MsaBaseSectMapper extends CommonMapper<MsaBaseSect>{
	List<SectAndEnterpriseVo> getSectAndEnterpriseList(SectAndEnterpriseVo sectAndEnterpriseVo);
}
