package com.junly.base.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junly.base.mapper.master.QueryStudentInfoMapper;
import com.junly.base.mapper.slaver.QuerySchoolInfoMapper;
import com.junly.base.service.TestService;
import com.junly.base.vo.PrivilegeVo;
import com.junly.base.vo.User;

@Service
public class TestServiceImpl implements TestService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	QueryStudentInfoMapper studentMapper;
	
	@Autowired
	QuerySchoolInfoMapper schoolMapper;
	
	@Override
	@Cacheable(cacheNames="queryStudentInfo") //使用redis实现缓存，必须配合配置
	public Map<String, Object> queryStudentInfo(String id) {
		logger.info("测试redis缓存");
		//调用slaver的数据源
		Map<String, Object> schoolName = schoolMapper.getSchoolName(id);
		//调用master的数据源
		Map<String, Object> queryStudentInfo = studentMapper.queryStudentInfo(id);
		logger.info(schoolName == null?"":schoolName.toString());
		logger.info(queryStudentInfo == null?"":queryStudentInfo.toString());
		return studentMapper.queryStudentInfo(id);
	}

	/**
	 * 使用事务管理
	 */
	@Override
	public List<PrivilegeVo> queryPrivilege(int userId) {
		
		List<PrivilegeVo> userPrivilege = studentMapper.queryPrivilege(userId);
		
		return userPrivilege;
	}

	@Override
	@Transactional(transactionManager="masterTransactionManager")
	public void saveUser(User user) {
		logger.info("添加用户开始："+user);
		studentMapper.saveUser(user);
		//检验事务的有效性
		int a = 1/0; 
		logger.info("添加用户结束："+user);
	}
	
	

}
