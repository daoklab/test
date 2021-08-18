package com.daoklab.test.dbid.commons.enums;

/**
 * 
 * @Title : ErrorCodeTypeEnum.java
 * @Descript : 错误类型
 * @date : 2020-06-30 10:18:37
 * @vsersion : V1.0
 */
public enum ErrorCodeTypeEnum {
	
	/**参数错误**/
	P("P","参数错误"),
	
	/**业务错误**/
	B("B","业务错误"),
	
	/**网络错误**/
	N("N","网络错误"),
	
	/**文件IO出错**/
	F("F","文件IO出错"),
	
	/**数据库出错**/
	D("D","数据库出错"),
	
	/**redis出错**/
	R("R","redis出错"),
	
	/**调用外部(第三方)系统出错**/
	T("T","调用外部(第三方)系统出错"),
	
	/**其他错误**/
	O("O","其他错误");
	
	String errorCodeType;
	String errorCodeName;
	
	/**
	 * 
	 * @param errorCodeType 错误类型。只能是1位字母
	 * @param errorCodeName
	 */
	private ErrorCodeTypeEnum(String errorCodeType, String errorCodeName) {
		this.errorCodeType = errorCodeType;
		this.errorCodeName = errorCodeName;
	}

	public String getErrorCodeType() {
		return errorCodeType;
	}

	public void setErrorCodeType(String errorCodeType) {
		this.errorCodeType = errorCodeType;
	}

	public String getErrorCodeName() {
		return errorCodeName;
	}

	public void setErrorCodeName(String errorCodeName) {
		this.errorCodeName = errorCodeName;
	}
	
	

}
