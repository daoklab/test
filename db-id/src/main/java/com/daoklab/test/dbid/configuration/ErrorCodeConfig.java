package com.daoklab.test.dbid.configuration;

/**
 * 
 * @Title : ErrorCodeConfig.java
 * @Descript : 系统内部错误码
 * @date : 2020-07-09 09:35:44
 * @vsersion : V1.0
 */
public class ErrorCodeConfig {
	
	/**接口开发中**/
	public static final String API_DEV = "000";
	
	/**未知的错误**/
	public static final String unKownError = "999";
	
	/**参数出错,指API接口获取到的客户端参数异常。如格式问题,或参数值业务校验失败**/
	public static final String paramError = "010";
	


	

	/**业务出错,一般指的是业务处理出现异常,如不符合某些规范**/
	public static final String busiError = "020";




	/**Excel文件读取出错**/
	public static final String Excel_error = "300";

	/**Excel文件读取出错-值不正确**/
	public static final String Excel_param_error = "301";
	
	/**文件IO出错**/
	public static final String IOError = "030";
	
	/**文件IO出错-模板文件没找到**/
	public static final String IOError_TemplateNotFoundException = "031";
	
	/**文件IO出错-模板文件没找到**/
	public static final String IOError_TemplateException = "032";
	
	/**文件IO出错-模板文件没找到**/
	public static final String IOError_MalformedTemplateNameException = "033";
	
	/**文件IO出错-模板文件没找到**/
	public static final String IOError_TemplateParseException = "034";
	
	
	/**调用其他系统出错**/
	public static final String otherSystemError = "040";
	
	/**网路错误-SocketException**/
	public static final String netErrorSocket = "041";
	
	/**网路错误-SocketTimeoutException**/
	public static final String netErrorSocketTimeout = "042";
	
	/**网路错误-BindException**/
	public static final String netErrorStcketBind = "043";
	
	/**网路错误-ConnectException**/
	public static final String netErrorConnect = "044";
	
	/**网路错误-EOFException**/
	public static final String netErrorEOF = "045";
	
	
	
	/**SQL错误**/
	public static final String sqlError = "050";
	
	/**redis**/
	public static final String redisError = "060";
	
	
	/** 数据字典-当前服务 **/
	public static final String dict_query_currentSys_Error = "091";
	
	
	/** 数据字典-cms **/
	public static final String query_cms_Error = "070";
	
	/** 数据字典-cms **/
	public static final String query_cms_up_Error = "071";
	
	/** 数据字典-文件服务 **/
	public static final String dict_query_fs_Error = "073";
	
	/** 数据字典-fsip **/
	public static final String dict_query_fsip_Error = "074";
	
	/** 数据字典-fsip-mkdir **/
	public static final String dict_query_fsip_mkdir_Error = "075";
	
	/** 数据字典-fsip-mkdir **/
	public static final String dict_query_fsip_up_Error = "076";
	
	/** 数据字典-fsip-mkdir **/
	public static final String dict_query_nfs_Error = "077";
	
	/** 下载文件失败 **/
	public static final String down_load_file_error = "080";
	
	/** 下载文件失败 **/
	public static final String down_load_file_getpdfPage_error = "081";




}
