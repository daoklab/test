package com.daoklab.test.dbid.commons.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 
 * @Title : BaseRequest.java
 * @Package : cn.tf.mg.opm.intermediate.commons.base
 * @Descript : 请求参数的基类
 * @date : 2020-07-10 09:57:10
 * @vsersion : V1.0
 */
public class BaseRequest implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1818677358774042464L;

    @JsonIgnore
    @Min(value = 1, message = "查询页数必须大于等于1")
    private Integer pageNum;

    @JsonIgnore
    @Min(value = 1, message = "每页数量必须大于等于1")
    private Integer pageSize;
    
    @JsonIgnore
    private String keywords;//搜索关键字

    public Integer getPageNum() {
        if (pageNum == null) {
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return 10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
    
    
}
