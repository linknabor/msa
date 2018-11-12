package com.eshequ.msa.bdp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.bdp.model.MsaBaseRegion;
import com.eshequ.msa.common.CommonMapper;

public interface MsaBaseRegionMapper extends CommonMapper<MsaBaseRegion>{
	  List<MsaBaseRegion> getAllRegion(@Param("cityId") Long cityId);
}
