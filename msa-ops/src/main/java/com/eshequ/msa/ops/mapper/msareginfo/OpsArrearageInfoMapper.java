package com.eshequ.msa.ops.mapper.msareginfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.ops.model.msareginfo.OpsArrearageInfo;

public interface OpsArrearageInfoMapper extends CommonMapper<OpsArrearageInfo> {
List<OpsArrearageInfo> findMobileByImpotBatchs(@Param("importBatchs")String[] importBatchs);
OpsArrearageInfo findInfoByMobile(@Param("mobile")String mobile);
}
