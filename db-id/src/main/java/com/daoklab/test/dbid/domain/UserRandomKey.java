package com.daoklab.test.dbid.domain;

import com.daoklab.test.dbid.commons.base.BaseDomain;

/**
 * user_random_key
 */
public class UserRandomKey extends BaseDomain {
	private static final long serialVersionUID = 1L;

	private Long userId; // 
	private String userName; // 
	private Integer sex; // 
	private String address; // 
	private String city; // 
	private String email; // 
	private Integer state; // 
	
	public UserRandomKey() {
		super();
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	} 
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	} 
	
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	} 
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	} 
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	} 
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	} 
	

}
