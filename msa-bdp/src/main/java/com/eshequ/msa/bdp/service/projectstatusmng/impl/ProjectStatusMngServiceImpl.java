package com.eshequ.msa.bdp.service.projectstatusmng.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.bdp.mapper.projectstatusmng.MsaBaseSectMapper;
import com.eshequ.msa.bdp.model.projectstatusmng.MsaBaseSect;
import com.eshequ.msa.bdp.service.projectstatusmng.ProjectStatusMngService;
import com.eshequ.msa.bdp.vo.SectAndEnterpriseVo;
import com.eshequ.msa.common.BaseResult;
@Service
@Transactional
public class ProjectStatusMngServiceImpl implements ProjectStatusMngService {
	@Autowired
	private MsaBaseSectMapper msaBaseSectMapper;
	@Override
	public BaseResult<?> updateMasBaseSect(MsaBaseSect masBaseSect) {
		msaBaseSectMapper.updateByPrimaryKeySelective(masBaseSect);
		return null;
	}
	@Override
	public List<SectAndEnterpriseVo> getSectAndEnterpriseList(SectAndEnterpriseVo sectAndEnterpriseVo) {
		return msaBaseSectMapper.getSectAndEnterpriseList(sectAndEnterpriseVo);
	}
    
}
