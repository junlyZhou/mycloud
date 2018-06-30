package com.junly.base.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryStudentInfoMapper {
	
	public Map<String,Object> queryStudentInfo(String id);
	
}
