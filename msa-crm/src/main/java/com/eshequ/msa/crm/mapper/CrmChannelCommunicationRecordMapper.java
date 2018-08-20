package com.eshequ.msa.crm.mapper;

import com.eshequ.msa.crm.model.CrmChannelCommunicationRecord;
import com.eshequ.msa.crm.model.CrmChannelCommunicationRecordKey;

public interface CrmChannelCommunicationRecordMapper {
    int deleteByPrimaryKey(CrmChannelCommunicationRecordKey key);

    int insert(CrmChannelCommunicationRecord record);

    int insertSelective(CrmChannelCommunicationRecord record);

    CrmChannelCommunicationRecord selectByPrimaryKey(CrmChannelCommunicationRecordKey key);

    int updateByPrimaryKeySelective(CrmChannelCommunicationRecord record);

    int updateByPrimaryKey(CrmChannelCommunicationRecord record);
}