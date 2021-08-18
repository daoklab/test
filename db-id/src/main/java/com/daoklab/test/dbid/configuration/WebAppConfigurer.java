package com.daoklab.test.dbid.configuration;

import com.daoklab.test.dbid.interceptor.GlobalInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer
 *
 * @Title : WebAppConfigurer.java
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAppConfigurer.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LOGGER.info("加载自定义拦截器");
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new GlobalInterceptor());
//        interceptorRegistration.addPathPatterns("/**");//所有的路径都要被拦截
        //interceptorRegistration.excludePathPatterns("");//不需要被拦截的路径
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");
        /*registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns(
                "/swagger-resources/**",
                "/doc.html/**",
                "/webjars/**",
                "/service-worker.js**",
                "/captcha/**",
                "/login/**",
                "/register/**",
                "/test/**",
                "/verify/**"
        );*/
    }

}
