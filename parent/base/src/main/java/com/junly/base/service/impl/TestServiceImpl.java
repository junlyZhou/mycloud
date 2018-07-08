package com.junly.base.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.base.mapper.master.QueryStudentInfoMapper;
import com.junly.base.mapper.slaver.QuerySchoolInfoMapper;
import com.junly.base.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	QueryStudentInfoMapper studentMapper;
	
	@Autowired
	QuerySchoolInfoMapper schoolMapper;
	
	@Override
	public Map<String, Object> queryStudentInfo(String id) {
		//调用slaver的数据源
		Map<String, Object> schoolName = schoolMapper.getSchoolName(id);
		//调用master的数据源
		Map<String, Object> queryStudentInfo = studentMapper.queryStudentInfo(id);
		logger.info(schoolName == null?"":schoolName.toString());
		logger.info(queryStudentInfo == null?"":queryStudentInfo.toString());
		return studentMapper.queryStudentInfo(id);
	}

}
