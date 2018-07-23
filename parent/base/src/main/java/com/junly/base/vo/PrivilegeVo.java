package com.junly.base.vo;

import java.io.Serializable;

public class PrivilegeVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String userName ;
	
	private String privilegeFlag;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPrivilegeFlag() {
		return privilegeFlag;
	}

	public void setPrivilegeFlag(String privilegeFlag) {
		this.privilegeFlag = privilegeFlag;
	}
	
}
