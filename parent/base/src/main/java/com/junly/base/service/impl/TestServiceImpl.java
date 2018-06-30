package com.junly.base.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.base.mapper.QueryStudentInfoMapper;
import com.junly.base.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	QueryStudentInfoMapper studentMapper;
	
	@Override
	public Map<String, Object> queryStudentInfo(String id) {
		return studentMapper.queryStudentInfo(id);
	}

}
