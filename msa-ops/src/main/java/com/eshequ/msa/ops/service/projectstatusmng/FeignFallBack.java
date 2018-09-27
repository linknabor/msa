package com.eshequ.msa.ops.service.projectstatusmng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.vo.projectstatusmng.SectAndEnterpriseVo;

@Component
public class FeignFallBack implements BdpSectAndEnterpriseRemote {

	@Autowired
	private BdpSectAndEnterpriseRemote bdpSectAndEnterpriseRemote;
	private int i = 0;

	@Override
	public BaseResult<?> getSectAndEnterpriseList(int pageNum, int pageSize, SectAndEnterpriseVo sectAndEnterpriseVo) {
		BaseResult<?> result = new BaseResult<>();
		i++;
		if (i > 3) {
			result = BaseResult.fail("网络连接异常,请重试！");
			i = 0;
		} else {
			result = bdpSectAndEnterpriseRemote.getSectAndEnterpriseList(pageNum, pageSize, sectAndEnterpriseVo);
		}
		return result;
	}

	@Override
	public int updateMasBaseSect(MsaBaseSect msaBaseSect) {
		i++;
		int count;
		if (i > 3) {
			count = 2;
			i = 0;
		} else {
			count = bdpSectAndEnterpriseRemote.updateMasBaseSect(msaBaseSect);
		}
		return count;
	}

}
