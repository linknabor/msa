package com.eshequ.msa.bdp.service.usercfg.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.bdp.mapper.MsaBaseSectMapper;
import com.eshequ.msa.bdp.mapper.MsaCfgSectParaMapper;
import com.eshequ.msa.bdp.model.MasConfigParamVO;
import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.model.MsaCfgSectPara;
import com.eshequ.msa.bdp.service.usercfg.SectConfigService;
import com.eshequ.msa.common.BaseModel;
import com.eshequ.msa.common.BaseResult;
import com.github.pagehelper.PageHelper;

@Service
public class SectConfigServiceImpl implements SectConfigService{
	@Autowired
	private MsaCfgSectParaMapper cfgSectParaMapper;
	@Autowired
	private MsaBaseSectMapper baseSectMapper;

	//根据企业客户信息获得物业项目信息
	@Override
	public List<MsaBaseSect> getSectByEnterpriseId(String sectName,String  sectAddr,Long enterpriseId,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<MsaBaseSect> list = baseSectMapper.getSectByEnterpriseId(sectName,sectAddr,enterpriseId);
		return list;
	}

	//根据物业项目信息获得项目参数配置
	@Override
	public List<MsaCfgSectPara> getSectConfigBySectId(Long sectId) {
		//分组查询参数
		List<MsaCfgSectPara> msaCfgSectParaList = cfgSectParaMapper.getMsaCfgSectParaGroup(sectId);
		for (MsaCfgSectPara msaCfgSectPara : msaCfgSectParaList) {
			// 根据每一个分组的参数，查询和它名称相同的数据，然后放入当前参数的list中，list>1的表示select类型参数，<1的表示input参数
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sectId", msaCfgSectPara.getSectId());
			map.put("paraName", msaCfgSectPara.getParaName());
			map.put("paraNameCN", msaCfgSectPara.getParaNameCn());
			List<MasConfigParamVO> oo = cfgSectParaMapper.getMsaCfgSectParaByParam(map);
			msaCfgSectPara.setCfgList(oo);// 添加筛选的参数到list
		}
		return msaCfgSectParaList;
	}	

	//根据项目参数配置id修改项目参数配置
	@Override
	public BaseResult<?> updateCfgSectByParaId(Long paraId, String value) {
		MsaCfgSectPara m  = new MsaCfgSectPara();
		m.setParaId(paraId);
		MsaCfgSectPara msaCfgEnpPara = cfgSectParaMapper.selectOne(m);//根据条件查询企业参数配置
		msaCfgEnpPara.setParaValue(value);
		int i = cfgSectParaMapper.updateCfgSectByParaId(msaCfgEnpPara);//修改内容
		if(i == 1) {
			return BaseResult.successResult("修改成功！");
		}
		return BaseResult.fail("修改失败！");
	}

}
