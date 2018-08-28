package com.eshequ.msa.crm.mapper.targetcustmapper;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.crm.model.targetcustmodel.CrmChannelLink;
import com.eshequ.msa.crm.model.targetcustmodel.CrmChannelLinkKey;

public interface CrmChannelLinkMapper extends CommonMapper<CrmChannelLink> {
    int deleteByPrimaryKey(CrmChannelLinkKey key);

    int insert(CrmChannelLink record);

    int insertSelective(CrmChannelLink record);

    CrmChannelLink selectByPrimaryKey(CrmChannelLinkKey key);

    int updateByPrimaryKeySelective(CrmChannelLink record);

    int updateByPrimaryKey(CrmChannelLink record);
}