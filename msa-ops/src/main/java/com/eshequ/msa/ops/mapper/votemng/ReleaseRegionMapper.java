package com.eshequ.msa.ops.mapper.votemng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.ops.model.votemng.ReleaseRegion;

public interface ReleaseRegionMapper extends CommonMapper<ReleaseRegion>{

	void deleteVoteReleaseByReleaseId(@Param("releaseId")Long releaseId);

	List<ReleaseRegion> getReleaseRegionByreleaseId(@Param("releaseId")Long releaseId);

}
