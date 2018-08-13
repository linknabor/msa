package com.eshequ.msa.crm.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * common mapper
 */
public interface CommonMapper<T> extends MySqlMapper<T>, Mapper<T> {
	
}