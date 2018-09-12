package com.eshequ.msa.bdp.service.usercfg.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.bdp.mapper.MsaCfgSectParaMapper;
import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.service.usercfg.SectConfigService;
import com.eshequ.msa.common.BaseModel;

@Service
public class SectConfigServiceImpl implements SectConfigService{
	@Autowired
	private MsaCfgSectParaMapper cfgSectParaMapper;

	//根据企业客户信息获得物业项目信息
	@Override
	public List<MsaBaseSect> getSectByEnterpriseId(Long enterpriseId,BaseModel model) {
		Map<String,Object> map = new HashMap<String,Object>();
		int page = model.getPage();//当前页(默认1)
		int rows = model.getRows();//显示数量(默认10)
		map.put("enterpriseId", enterpriseId);//企业id
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		List<MsaBaseSect> list = cfgSectParaMapper.getSectByEnterpriseId(map);
		return list;
	}

}
