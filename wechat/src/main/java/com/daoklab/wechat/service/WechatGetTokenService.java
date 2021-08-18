package com.daoklab.wechat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.daoklab.wechat.utils.HttpsClientRequestFactory;
import com.daoklab.wechat.utils.HttpsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Collections;

@Service
public class WechatGetTokenService {

    private static final String GET_WECHAT_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";
    private static final String GET_WECHAT_USER_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token={0}&next_openid={1}";
    private static final String GET_WECHAT_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}&lang=zh_CN";
    private static final String GET_WECHAT_WEB_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code";
    private static final String GET_WECHAT_USER_INFO_BY_OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN";

    @Autowired
    private HttpsUtil httpsUtil;

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String secret;

    /**
     * 获取Access token
     *
     * @return
     */
    public JSONObject getWechatToken() {
        String URL = MessageFormat.format(GET_WECHAT_TOKEN_URL, appid, secret);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(URL, JSONObject.class);
        return JSON.parseObject(JSONObject.toJSONString(forEntity));
    }

    /**
     * 获取用户基本信息(UnionID机制)
     *
     * @param openId 关注公众号用户的OpenID
     * @return
     */
    public JSONObject getUsersBasicInformationUnionID(String openId) {
        String token = getWechatToken().getJSONObject("body").getString("access_token");
        String URL = MessageFormat.format(GET_WECHAT_USER_INFO_URL, token, openId);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(URL, JSONObject.class);
        return JSON.parseObject(JSONObject.toJSONString(forEntity));
    }

    /**
     * 获取用户基本信息(AccessToken机制)
     *
     * @param accessToken
     * @param openId      关注公众号用户的OpenID
     * @return
     */
    public JSONObject getUserInfoByAccessToken(String accessToken, String openId) {
        String URL = MessageFormat.format(GET_WECHAT_USER_INFO_BY_OAUTH2_ACCESS_TOKEN, accessToken, openId);
        StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        restTemplate.setMessageConverters(Collections.singletonList(m));
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        ResponseEntity<String> forEntity = restTemplate.getForEntity(URL, String.class);
        return JSON.parseObject(forEntity.getBody());
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    public JSONObject getUserList() {
        String token = getWechatToken().getJSONObject("body").getString("access_token");
        String URL = MessageFormat.format(GET_WECHAT_USER_LIST_URL, token, "");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(URL, JSONObject.class);
        return JSON.parseObject(JSONObject.toJSONString(forEntity));
    }

    /**
     * 通过https方式请求获得web_access_token
     *
     * @param appid
     * @param secret
     * @param code
     * @return
     */
    public JSONObject getWebAccessToken(String appid, String secret, String code) {
        String URL = MessageFormat.format(GET_WECHAT_WEB_ACCESS_TOKEN_URL, appid, secret, code);
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        ResponseEntity<String> exchange = restTemplate.getForEntity(URL, String.class);
        return JSON.parseObject(exchange.getBody());
    }

}
