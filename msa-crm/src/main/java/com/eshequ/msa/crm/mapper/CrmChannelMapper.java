package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.CrmChannel;

public interface CrmChannelMapper extends CommonMapper<CrmChannel> {
    int deleteByPrimaryKey(String channelId);

    int insert(CrmChannel record);

    int insertSelective(CrmChannel record);

    CrmChannel selectByPrimaryKey(String channelId);

    int updateByPrimaryKeySelective(CrmChannel record);

    int updateByPrimaryKey(CrmChannel record);
}