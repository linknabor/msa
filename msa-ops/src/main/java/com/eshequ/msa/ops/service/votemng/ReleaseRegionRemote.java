package com.eshequ.msa.ops.service.votemng;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshequ.msa.common.BaseResult;



@FeignClient(value = "msa-bdp",fallback=ReleaseRegionFeignFallBack.class)
public interface ReleaseRegionRemote {
	        //根据cityid获取所有区域
			@RequestMapping(value="/bdp/voteMng/getAllRegion",method=RequestMethod.GET,consumes="application/json")
			BaseResult<?> getAllRegion(@RequestParam("cityId")Long cityId);
			
			  //根据cityid获取所有区域
			@RequestMapping(value="/bdp/voteMng/getAllSect",method=RequestMethod.GET,consumes="application/json")
			BaseResult<?> getAllSect(@RequestParam("regionId")Long regionId);
}
