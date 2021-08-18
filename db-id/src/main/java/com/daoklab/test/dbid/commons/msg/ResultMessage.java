package com.daoklab.test.dbid.commons.msg;

import com.daoklab.test.dbid.commons.enums.ErrorCodeTypeEnum;
import com.daoklab.test.dbid.commons.enums.SystemCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * 消息体由三部分组成：code，msg，body<br/>
 * code:错误编码。6位数长度。一切正常执行成功就的编码:000000，其他非正常处理的业务编码：前两位表示系统编号，第三位表示错误类型，后三位是每个系统内部定义的错误编码.<br/>
 * msg:错误消息提示<br/>
 * body:返回的消息体<br/>
 *
 * @Title : ResultMessage.java
 * @Descript :resultfulAPI-统一返回的消息体
 * @date : 2020-06-29 04:46:55
 * @vsersion : V1.0
 */
@ApiModel(value = "统一返回的消息体")
public class ResultMessage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 820592085459570906L;

    /**
     * 成功的编码
     **/
    public static final String SUCCESS_CODE = "000000";
    @ApiModelProperty(value = "消息编码", notes = "消息编码。前两位表示系统编号，第三位表示错误类型，后三位是每个系统内部定义的错误编码", required = true)
    private String code;//消息编码。前两位表示系统编号，第三位表示错误类型，后三位是每个系统内部定义的错误编码

    @ApiModelProperty(value = "消息描述", notes = "消息描述", required = true)
    private String msg;//消息描述

    @ApiModelProperty(value = "返回的消息体", notes = "返回的消息体", required = true)
    private Object body;//返回的消息体

    /**
     * 返回的消息体,非
     *
     * @param errCodeType 错误类型;在commons的枚举对象ErrorCodeTypeEnum中定义
     * @param code        错误编码:由内个系统内部自己定义。长度三位数;
     * @param msg         错误码的文字描述
     * @param body        返回的消息体
     */
    public ResultMessage(SystemCodeEnum sysCode, ErrorCodeTypeEnum errCodeType, String code, String msg, Object body) {
        //前两位表示系统编号,第三位表示错误类型,后三位是每个系统内部定义的错误编码
        this.code = sysCode.getSysCode() + errCodeType.getErrorCodeType() + code;
        this.msg = msg;
        this.body = body;
    }

    /**
     * 一切OK时调用这个方法<br/>该方法返回的code是:000000
     *
     * @param body
     * @return
     * @Title: ResultSuccessMessage
     */
    public static ResultMessage ResultSuccessMessage(Object body) {
        ResultMessage rm = new ResultMessage();
        rm.setCode(SUCCESS_CODE);
        rm.setMsg("成功");
        rm.setBody(body);
        return rm;
    }

    /**
     * 一切OK时调用这个方法<br/>该方法返回的code是:000000
     *
     * @param msg
     * @param body
     * @return
     * @Title: ResultSuccessMessage
     */
    public static ResultMessage ResultSuccessMessage(String msg, Object body) {
        ResultMessage rm = new ResultMessage();
        rm.setCode(SUCCESS_CODE);
        rm.setMsg(StringUtils.isNotBlank(msg) ? msg : "成功");
        rm.setBody(body);
        return rm;
    }

    /**
     * 是否成功
     *
     * @return
     * @Title: codeIsSuccess
     */
    public boolean codeIsSuccess() {
        return SUCCESS_CODE.equals(this.code);
    }

    /**
     * 获取消息对应的的系统来源
     *
     * @return
     * @Title: getSystemCode
     */
    public String codeSystemCode() {
        if (StringUtils.isNotBlank(this.code)) {
            return this.code.substring(0, 2);
        }
        return null;
    }

    /**
     * 获取消息对应的错误类型
     *
     * @return
     * @Title: codeErrorCodeTye
     */
    public String codeErrorCodeTye() {
        if (StringUtils.isNotBlank(this.code)) {
            return this.code.substring(2, 3);
        }
        return null;
    }

    private ResultMessage() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }


}
