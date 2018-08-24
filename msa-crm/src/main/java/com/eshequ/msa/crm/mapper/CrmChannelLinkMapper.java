package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.CrmChannelLink;
import com.eshequ.msa.crm.model.CrmChannelLinkKey;

public interface CrmChannelLinkMapper extends CommonMapper<CrmChannelLink> {
    int deleteByPrimaryKey(CrmChannelLinkKey key);

    int insert(CrmChannelLink record);

    int insertSelective(CrmChannelLink record);

    CrmChannelLink selectByPrimaryKey(CrmChannelLinkKey key);

    int updateByPrimaryKeySelective(CrmChannelLink record);

    int updateByPrimaryKey(CrmChannelLink record);
}