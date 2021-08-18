package com.daoklab.wechat.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.daoklab.wechat.service.WechatGetTokenService;
import com.daoklab.wechat.utils.HttpsUtil;
import com.daoklab.wechat.utils.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

@RequestMapping("/wx")
@Controller
public class IndexController {

    @Autowired
    private WechatGetTokenService wechatGetTokenService;

    @Autowired
    private SHA1 sha1;

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String secret;

    @RequestMapping("/index")
    public String web() {
        return "index";
    }

    @GetMapping(produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String callBack(@RequestParam(name = "signature", required = false) String signature,
                           @RequestParam(name = "timestamp", required = false) String timestamp,
                           @RequestParam(name = "nonce", required = false) String nonce,
                           @RequestParam(name = "echostr", required = false) String echostr) {
        System.out.println(MessageFormat.format("接收到来自微信服务器的认证消息：[{0}, {1}, {2}, {3}]", signature, timestamp, nonce, echostr));
        ;
        String token = "s98duf90as8dyf09asyf09as7f0as97gf0as7g";
        if (sha1.gen(new String[]{token, timestamp, nonce}).equals(signature)) {
            System.out.println("校验通过");
            return echostr;
        } else {
            System.out.println("非法请求");
            return "非法请求";
        }
    }

    @RequestMapping("/token")
    @ResponseBody
    public String getWechatToken(HttpServletRequest request) {
        return wechatGetTokenService.getWechatToken().toJSONString();
    }

    @RequestMapping("/user/{openId}")
    @ResponseBody
    public String getUsersBasicInformationUnionID(@PathVariable("openId") String openId, HttpServletRequest request) {
        return wechatGetTokenService.getUsersBasicInformationUnionID(openId).toJSONString();
    }

    @RequestMapping("/users")
    @ResponseBody
    public String getUserList() {
        return wechatGetTokenService.getUserList().toJSONString();
    }

    @RequestMapping("/getAccess_Token")
    @ResponseBody
    public String getAccessToken(@RequestParam(name = "code", required = false) String code,
                                 @RequestParam(name = "state") String state) {
        System.out.println("--收到微信服务器请求，请求数据为：" + code + "--" + state);
//通过code换取网页授权web_access_token
        if (code != null || !(code.equals(""))) {
            JSONObject webAccessToken = wechatGetTokenService.getWebAccessToken(appid, secret, code);
            String accessToken = webAccessToken.getString("access_token");
            String openId = webAccessToken.getString("openid");
            JSONObject wechatUserInfo = wechatGetTokenService.getUserInfoByAccessToken(accessToken, openId);
            if (wechatUserInfo != null) {
                try {
                    //用户昵称
                    String nickName = wechatUserInfo.getString("nickname");
                    //用户性别
                    String sex = wechatUserInfo.getString("sex");
                    sex = (sex.equals("1")) ? "男" : "女";
                    //用户唯一标识
                    String openid = wechatUserInfo.getString("openid");
                    System.out.println("用户昵称------------------------" + nickName);
                    System.out.println("用户性别------------------------" + sex);
                    System.out.println("用户的唯一标识-------------------" + openid);
                    return wechatUserInfo.toJSONString();
                } catch (JSONException e) {
                    System.out.println("获取userName失败");
                    return "登录成功，获取用户信息失败";
                }
            }
        }
        return "登录失败";
    }

}
