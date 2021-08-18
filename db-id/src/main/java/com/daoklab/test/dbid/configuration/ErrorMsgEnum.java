package com.daoklab.test.dbid.configuration;

/**
 * @ClassName: ErrorMsgEnum
 * @Author: ztzh_liuxl
 * @Date: 2020/08/12 14:58
 * @Version: 1.0
 */
public enum ErrorMsgEnum {

    API_NOT_OPEN("001", Constants.API_NOT_OPEN),
    NOT_QUERY_DATA("020", Constants.NOT_QUERY_DATA),
    NOT_UPLOAD_FILE("304", Constants.NOT_UPLOAD_FILE),
    TIMEOUT_TOKEN("402", Constants.TIMEOUT_TOKEN),
    INVALID_AUTH("403", Constants.INVALID_AUTH),
    INVALID_TOKEN("401", Constants.INVALID_TOKEN),
    NOT_APPROVAL("500", Constants.NOT_APPROVAL);

    String errorCode;
    String errorCodeName;

    ErrorMsgEnum(String errorCode, String errorCodeName) {
        this.errorCode = errorCode;
        this.errorCodeName = errorCodeName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCodeName() {
        return errorCodeName;
    }

    public void setErrorCodeName(String errorCodeName) {
        this.errorCodeName = errorCodeName;
    }

}