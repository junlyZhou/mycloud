package com.junly.base.mapper.master;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.junly.base.mapper.annotation.MasterDBS;
import com.junly.base.vo.PrivilegeVo;
import com.junly.base.vo.User;

//@Mapper
@MasterDBS //使用注解注入对应的数据源
public interface QueryStudentInfoMapper {
	
	public Map<String,Object> queryStudentInfo(String id);
	
	/**
	 * 根据userId 查询用户权限
	 * @param userId
	 * @return
	 */
	public List<PrivilegeVo> queryPrivilege(int userId);
	/**
	 * 添加用户
	 * @param user
	 */
	public void saveUser(User user);
	
}
