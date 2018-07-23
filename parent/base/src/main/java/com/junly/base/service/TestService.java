package com.junly.base.service;

import java.util.List;
import java.util.Map;

import com.junly.base.vo.PrivilegeVo;
import com.junly.base.vo.User;

public interface TestService {
	
	public Map<String,Object> queryStudentInfo(String id);
	
	public List<PrivilegeVo> queryPrivilege(int userId);
	
	public void saveUser(User user);
	
}
