package com.daoklab.test.dbid.commons.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 
 * @Title : BaseDomain.java
 * @Package : cn.tf.mg.opm.intermediate.commons.base
 * @Descript : 基础domain
 * @date : 2020-07-20 05:42:29
 * @vsersion : V1.0
 */
public class BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 944525904541811926L;
	
	@JsonIgnore
	private String orderField;//排序字段
	
	@JsonIgnore
	private String orderFieldType;//排序类型
	
	@JsonIgnore
	private Integer startIndex;//开始页
	
	@JsonIgnore
	private String pageSize;//结束页码
	
	@JsonIgnore
    private String keywords;//搜索关键字

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderFieldType() {
		return orderFieldType;
	}

	public void setOrderFieldType(String orderFieldType) {
		this.orderFieldType = orderFieldType;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	
	

}
