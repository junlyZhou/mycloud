package com.junly.base.mapper.slaver;

import java.util.Map;

import com.junly.base.mapper.annotation.SlaverDBS;

@SlaverDBS
public interface QuerySchoolInfoMapper {

	public Map<String,Object> getSchoolName(String id);
	
}
