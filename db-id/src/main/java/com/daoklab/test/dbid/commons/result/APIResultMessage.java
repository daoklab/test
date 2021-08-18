package com.daoklab.test.dbid.commons.result;


import com.daoklab.test.dbid.commons.enums.ErrorCodeTypeEnum;
import com.daoklab.test.dbid.commons.enums.SystemCodeEnum;
import com.daoklab.test.dbid.commons.msg.ResultMessage;
import com.daoklab.test.dbid.configuration.ErrorCodeConfig;
import com.daoklab.test.dbid.configuration.ErrorMsgEnum;

/**
 * @author xianglin
 * @Title : APIResultMessage.java
 * @Descript : 这几基层下基础的ResultMessage ，在表单系统里面第一个系统编码参数否是固定的
 * @date : 2020-07-09 02:22:04
 * @vsersion : V1.0
 */
public class APIResultMessage extends ResultMessage {

    /**
     *
     */
    private static final long serialVersionUID = -7505365686321552272L;

    public APIResultMessage(ErrorCodeTypeEnum errCodeType, String code, String msg, Object body) {
        super(SystemCodeEnum.AN, errCodeType, code, msg, body);
    }

    /**
     * 参数异常返回信息
     *
     * @param msg 提示信息
     * @return
     */
    public static ResultMessage paramError(String msg) {
        APIResultMessage apiResultMessage = new APIResultMessage(ErrorCodeTypeEnum.P, ErrorCodeConfig.paramError, msg, null);
        return apiResultMessage;
    }

    /**
     * 数据库异常返回信息
     *
     * @param msg 提示信息
     * @return
     */
    public static ResultMessage databaseError(String msg) {
        return new APIResultMessage(ErrorCodeTypeEnum.D, ErrorCodeConfig.sqlError, msg, null);
    }

    /**
     * 业务出错,业务处理出现异常,如不符合某些规范
     *
     * @param msg
     * @return
     */
    public static ResultMessage busiError(String msg) {
        return new APIResultMessage(ErrorCodeTypeEnum.B, ErrorCodeConfig.busiError, msg, null);
    }

    /**
     * 业务出错,业务处理出现异常,如不符合某些规范
     *
     * @param errorMsgEnum
     * @return
     */
    public static ResultMessage busiError(ErrorMsgEnum errorMsgEnum) {
        return new ResultMessage(SystemCodeEnum.AN, ErrorCodeTypeEnum.B, errorMsgEnum.getErrorCode(), errorMsgEnum.getErrorCodeName(), null);
    }
}
