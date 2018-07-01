package com.junly.base.mapper.master;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.junly.base.mapper.annotation.MasterDBS;

//@Mapper
@MasterDBS
public interface QueryStudentInfoMapper {
	
	public Map<String,Object> queryStudentInfo(String id);
	
}
