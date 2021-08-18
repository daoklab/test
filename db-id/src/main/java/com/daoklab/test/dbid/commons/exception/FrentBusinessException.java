package com.daoklab.test.dbid.commons.exception;


import com.daoklab.test.dbid.commons.enums.ErrorCodeTypeEnum;

/**
 * 
 * @Title : FrentBusinessException.java
 * @Descript : 业务运行时异常
 * @date : 2020-06-29 04:59:44
 * @vsersion : V1.0
 */
public class FrentBusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 4693786499059513760L;
	
	private ErrorCodeTypeEnum errorCodeTypeEnum;
	
	private String errorDescription;
	
	private String errorCode;
	
	public FrentBusinessException(String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
	}

	public FrentBusinessException(String errorDescription, Throwable t) {
		super(errorDescription, t);
		this.errorDescription = errorDescription;
	}

	public FrentBusinessException(String code, String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = code;
	}

	public FrentBusinessException(String code, String errorDescription, Throwable t) {
		super(errorDescription, t);
		this.errorDescription = errorDescription;
		this.errorCode = code;
	}	
	
	public FrentBusinessException(ErrorCodeTypeEnum errorCodeTypeEnum, String code, String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = code;
		this.errorCodeTypeEnum = errorCodeTypeEnum;
	}

	public FrentBusinessException(ErrorCodeTypeEnum errorCodeTypeEnum, String code, String errorDescription, Throwable t) {
		super(errorDescription, t);
		this.errorDescription = errorDescription;
		this.errorCode = code;
		this.errorCodeTypeEnum = errorCodeTypeEnum;
	}	
	
	public String getErrorDescription() {
		return this.errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorTitle() {
		return "业务校验失败!";
	}

	public ErrorCodeTypeEnum getErrorCodeTypeEnum() {
		return errorCodeTypeEnum;
	}
	
	
	
}
