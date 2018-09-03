package com.eshequ.msa.ops.mapper.msareginfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.ops.model.msareginfo.MsaSmsSum;

public interface MsaSmsSumMapper  extends CommonMapper<MsaSmsSum>{
List<MsaSmsSum> findMsaSmsByDate(@Param("sendDate")String sendDate);
}
