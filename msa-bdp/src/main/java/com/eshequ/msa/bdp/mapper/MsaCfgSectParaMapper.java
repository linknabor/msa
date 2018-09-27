package com.eshequ.msa.bdp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.bdp.model.MasConfigParamVO;
import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.model.MsaCfgSectPara;
import com.eshequ.msa.common.CommonMapper;

public interface MsaCfgSectParaMapper extends CommonMapper<MsaCfgSectPara> {

	/**
	 * 去重（分组）查询项目对应的参数列表
	 * @param sectId
	 * @return
	 */
	List<MsaCfgSectPara>  getMsaCfgSectParaGroup(@Param("sectId") Long sectId);
	
	/**
	 * 获得项目参数的参数
	 * @param map
	 * @return
	 */
	List<MasConfigParamVO> getMsaCfgSectParaByParam(Map<String,Object> map);
	
	/**
	 * 根据项目参数配置id修改项目参数配置
	 * @param cfgSectPara
	 * @return
	 */
	int updateCfgSectByParaId(MsaCfgSectPara cfgSectPara);
}
