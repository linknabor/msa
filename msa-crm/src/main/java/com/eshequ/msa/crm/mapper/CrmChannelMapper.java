package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.crm.model.CrmChannel;

public interface CrmChannelMapper {
    int deleteByPrimaryKey(String channelId);

    int insert(CrmChannel record);

    int insertSelective(CrmChannel record);

    CrmChannel selectByPrimaryKey(String channelId);

    int updateByPrimaryKeySelective(CrmChannel record);

    int updateByPrimaryKey(CrmChannel record);
}