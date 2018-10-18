package com.eshequ.msa.ops.service.votemng;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshequ.msa.common.BaseResult;

@Component
public class ReleaseRegionFeignFallBack implements ReleaseRegionRemote{

	@Autowired
	private ReleaseRegionRemote releaseRegionRemote;
	private int i = 0;
	
	@Override
	public BaseResult<?> getAllRegion(Long cityId) {
		BaseResult<?> result = new BaseResult<>();
		i++;
		if (i > 3) {
			result = BaseResult.fail("网络连接异常,请重试！");
			i = 0;
		} else {
			result = releaseRegionRemote.getAllRegion(cityId);
		}
		return result;
	}

	@Override
	public BaseResult<?> getAllSect(Long regionId) {
		BaseResult<?> result = new BaseResult<>();
		i++;
		if (i > 3) {
			result = BaseResult.fail("网络连接异常,请重试！");
			i = 0;
		} else {
			result = releaseRegionRemote.getAllSect(regionId);
		}
		return result;
	}

}
