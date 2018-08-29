package com.eshequ.msa.crm.service.paraimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.crm.mapper.sysmapper.MsaCfgSysParaMapper;
import com.eshequ.msa.crm.model.sysmodel.MsaCfgSysPara;
import com.eshequ.msa.crm.service.ParaService;
import com.eshequ.msa.crm.vo.para.ParaVo;
import com.eshequ.msa.util.SnowFlake;
@Service
public class ParaServiceImpl implements ParaService{

	@Autowired
	private MsaCfgSysParaMapper mapper;
	
	@Autowired
	private SnowFlake snowFlake;
	
	@Override
	public List<MsaCfgSysPara> paraQueryAll() {
		List<MsaCfgSysPara> list = mapper.selectAll();
		return list;
	}

	@Override
	@Transactional
	public void paraEdit(ParaVo vo) {
		MsaCfgSysPara record = new MsaCfgSysPara();
		BeanUtils.copyProperties(vo, record);
		mapper.updateByPrimaryKey(record);
	}

}
