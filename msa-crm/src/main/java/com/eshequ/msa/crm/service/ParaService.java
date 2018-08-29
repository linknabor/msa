package com.eshequ.msa.crm.service;

import java.util.List;

import com.eshequ.msa.crm.model.sysmodel.MsaCfgSysPara;
import com.eshequ.msa.crm.vo.para.ParaVo;

public interface ParaService {

	List<MsaCfgSysPara> paraQueryAll();
	void paraEdit(ParaVo vo);
}
