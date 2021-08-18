package com.daoklab.test.dbid.commons.enums;

/**
 * @ClassName: SystemCodeEnum
 * @Author: ztzh_liuxl
 * @Date: 2020/12/07 8:18
 * @Version: 1.0
 */
public enum SystemCodeEnum {

    AN("AN", "TEST");

    String sysCode;
    String sysName;

    private SystemCodeEnum(String sysCode, String sysName) {
        this.sysCode = sysCode;
        this.sysName = sysName;
    }

    public String getSysCode() {
        return this.sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysName() {
        return this.sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

}
