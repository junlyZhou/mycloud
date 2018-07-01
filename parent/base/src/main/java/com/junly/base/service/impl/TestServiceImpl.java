package com.junly.base.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junly.base.mapper.master.QueryStudentInfoMapper;
import com.junly.base.mapper.slaver.QuerySchoolInfoMapper;
import com.junly.base.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	QueryStudentInfoMapper studentMapper;
	
	@Autowired
	QuerySchoolInfoMapper schoolMapper;
	
	@Override
	public Map<String, Object> queryStudentInfo(String id) {
		System.out.println("user slaver database print school info :");
		System.out.println(schoolMapper.getSchoolName(id));
		System.out.println(studentMapper.queryStudentInfo(id));
		
		return studentMapper.queryStudentInfo(id);
	}

}
