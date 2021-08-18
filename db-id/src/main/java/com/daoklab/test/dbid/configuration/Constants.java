package com.daoklab.test.dbid.configuration;


/**
 * 公共静态变量资源统一存放
 */
public class Constants {

    // Controller返回信息提示
    public static final String NOT_QUERY_DATA = "未查询到数据";
    public static final String NOT_QUERY_DATA_BY_NO = "不存在此编号数据";
    public static final String ALREADY_EXISTS = "已存在";
    public static final String INSERT_FAIL = "添加失败";
    public static final String MODIFY_SUCCESS = "修改成功";
    public static final String PARAM_ISEMPTY = "参数不能为空";
    public static final String DELETE_SUCCESS = "删除成功";
    public static final String API_NOT_OPEN = "接口暂未开放";
    public static final String TIMEOUT_TOKEN = "Token已过期";
    public static final String INVALID_TOKEN = "Invalid token";
    public static final String INVALID_AUTH = "鉴权失败: 暂无权限";
    public static final String NOT_APPROVAL = "文件发起审批中";
    public static final String NOT_UPLOAD_FILE = "文件从未上传";

    public static final Boolean SUCCESS = true;

    public static final Boolean FAIL = false;

    // 行内工单系统Code
    public static final String WORKORDER_SUCCESS_CODE = "00";

    // 文件分隔符
    public static final String FILE_SPLIT = "|";

    // Jira文件分隔符
    public static final String JIRA_FILE_SPLIT = ",";

    // 文件状态
    // 已被清空
    public static final String FILE_STATUS_CLEARED = "0";
    // 正常
    public static final String FILE_STATUS_NORMAL = "1";

    // 文件审批状态
    // 未审批
    public static final String FILE_NOT_APPORA_STATUS = "0";
    // 已审批
    public static final String FILE_PASS_APPORA_STATUS = "1";
    // 无需审批
    public static final String FILE_UNAPPORA_STATUS = "2";

}