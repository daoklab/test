package com.daoklab.test.dbid.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.daoklab.test.dbid.commons.constants.HeaderKeyConstants;
import com.daoklab.test.dbid.commons.constants.LogMDCKey;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @Title : GlobalInterceptor.java
 * @Descript : 拦截器
 * @Author: liuxl
 * @date : 2020-05-13 05:08:39
 * @vsersion : V1.0
 */
public class GlobalInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalInterceptor.class);

    /**
     * 前置请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Enumeration<String> headers = request.getHeaderNames();
        JSONObject headerMap = new JSONObject();
        String headerName;
        while (headers.hasMoreElements()) {
            headerName = headers.nextElement();
            headerMap.put(headerName, URLDecoder.decode(request.getHeader(headerName), "UTF-8"));
        }

        //RequestWrapper wrapper = new RequestWrapper(request);

        //TODO 后续这里要添加获取用户信息，如果没有则。跳出请求

        //获取或设置当前请求的唯一ID,如有MDCID，则表示是从其它服务传递过来的，否则生成一个MDCID
        String requestMDCID = request.getHeader(HeaderKeyConstants.REQUEST_MDC_ID);
        requestMDCID = StringUtils.isNotBlank(requestMDCID) ? requestMDCID : UUID.randomUUID().toString();

//        MyRequestWrapper myRequestWrapper = new MyRequestWrapper(request);
//        LOGGER.info(">>>>>>>>>>>>{}", myRequestWrapper.getBody());

        //TODO 设置MDC信息
        MDC.put(HeaderKeyConstants.REQUEST_MDC_ID, requestMDCID);//用在服务间的传播
        request.setAttribute(HeaderKeyConstants.REQUEST_MDC_ID, requestMDCID);//用在服务间的传播

        LOGGER.info(">>>>>>>>>>>>>>>>拦截器(preHandle): 请求基本信息：请求地址：{} \t请求类型:{}  \t请求参数:{}  \t请求header:{}", request.getRequestURI(), request.getMethod(), JSONObject.toJSONString(request.getParameterMap()), headerMap);

        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }

    /**
     * 视图渲染之后的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        Object responseBody = request.getAttribute("resopnseBodyFromAdviceXXX");
        Enumeration<String> headers = request.getHeaderNames();
        JSONObject headerMap = new JSONObject();
        String headerName;
        while (headers.hasMoreElements()) {
            headerName = headers.nextElement();
            headerMap.put(headerName, request.getHeader(headerName));
        }

        LOGGER.info(">>>>>>>>>>>>>>>>拦截器(afterCompletion): 请求基本信息：请求地址：{}  \t请求类型:{}  \t请求参数:{}\t请求header:{}\t返回结果：{}", request.getRequestURI(), request.getMethod(), JSONObject.toJSONString(request.getParameterMap()), headerMap, JSONObject.toJSONString(responseBody));
        MDC.remove(LogMDCKey.USER_INFO);
        MDC.remove(LogMDCKey.REQUEST_URL);
        MDC.remove(HeaderKeyConstants.REQUEST_MDC_ID);
    }

}
