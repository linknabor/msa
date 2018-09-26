package com.eshequ.msa.bdp.service.usercfg.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.bdp.mapper.MsaBaseEnterpriseMapper;
import com.eshequ.msa.bdp.mapper.MsaCfgEnpParaMapper;
import com.eshequ.msa.bdp.model.MasConfigParamVO;
import com.eshequ.msa.bdp.model.MsaBaseEnterprise;
import com.eshequ.msa.bdp.model.MsaCfgEnpPara;
import com.eshequ.msa.bdp.service.usercfg.EnpConfigService;
import com.eshequ.msa.common.BaseModel;
import com.eshequ.msa.common.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EnpConfigServiceImpl implements EnpConfigService{
	@Autowired
	private MsaBaseEnterpriseMapper msaBaseEnterpriseMapper;
	@Autowired
	private MsaCfgEnpParaMapper msaCfgEnpParaMapper;

	//获得企业客户信息
	@Override
	public List<MsaBaseEnterprise> getEnterprise(String enterpriseName,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<MsaBaseEnterprise> list =  msaBaseEnterpriseMapper.getEnterprise(enterpriseName);
		PageInfo<MsaBaseEnterprise> pageInfo = new PageInfo<>(list);
		return list;
	}

	//根据企业客户信息获得企业参数配置
	@Override
	public List<MsaCfgEnpPara> getEnterpriseConfigByEnterpriseId(Long enterpriseId) {
		//分组查询参数
		List<MsaCfgEnpPara> msaCfgEnpParaList = msaCfgEnpParaMapper.getMsaCfgEnpParaGroup(enterpriseId);
		for (MsaCfgEnpPara msaCfgEnpPara : msaCfgEnpParaList) {
			//根据每一个分组的参数，查询和它名称相同的数据，然后放入当前参数的list中，list>1的表示select类型参数，<1的表示input参数
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("enterpriseId", enterpriseId);
			map.put("paraName", msaCfgEnpPara.getParaName());
			map.put("paraNameCN", msaCfgEnpPara.getParaNameCn());
			List<MasConfigParamVO> oo = msaCfgEnpParaMapper.getMsaCfgEnpParaByParam(map);
			msaCfgEnpPara.setCfgList(oo);//添加筛选的参数到list
		}
		
		return msaCfgEnpParaList;
	}

	//根据企业配置id修改企业配置
	@Override
	public BaseResult<?> updateCfgEnpByParaId(Long paraId, String value) {
		MsaCfgEnpPara m  = new MsaCfgEnpPara();
		m.setParaId(paraId);
		MsaCfgEnpPara msaCfgEnpPara = msaCfgEnpParaMapper.selectOne(m);//根据条件查询企业参数配置
		msaCfgEnpPara.setParaValue(value);
		int i = msaCfgEnpParaMapper.updateCfgEnpByParaId(msaCfgEnpPara);//修改内容
		if(i == 1) {
			return BaseResult.successResult("修改成功！");
		}
		return BaseResult.fail("修改失败！");
	}

}
