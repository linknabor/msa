package com.eshequ.msa.ops.mapper.msareginfo;

import java.util.List;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.ops.model.msareginfo.MsaRegInfo;

public interface MsaRegInfoMapper extends CommonMapper<MsaRegInfo>{
	List<MsaRegInfo> getMsaInfoList(MsaRegInfo msaRegInfo);

}
