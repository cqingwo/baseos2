/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆英卡电子有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.services;

import com.alibaba.fastjson.JSON;
import com.cqwo.base.core.config.CWMConfig;
import com.cqwo.base.core.domain.base.AccessToken;
import com.cqwo.base.core.helper.*;
import com.cqwo.ucenter.client.domain.PartUserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cqnews on 2017/12/12.
 */
@Service(value = "CWMUtils")
public class CWMUtils {


    @Autowired
    private HttpServletRequest request;


    @Autowired
    private CWMConfig cwmConfig;

    @Autowired
    private Logs logs;


    public CWMUtils() {

        //this.request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ////System.out.print(request.toString());
        //this.response =  context.getServletContext().getAttribute("re");//((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();

    }


    //region  加密/解密

    /**
     * AES加密
     *
     * @param encryptStr 加密字符串\
     */
    public String aesEncrypt(String encryptStr) {
        try {
            return AESHelper.encode(encryptStr);
        } catch (Exception e) {
            logs.write(e, "AES加密");
        }
        return "";
    }


    /**
     * AES解密
     *
     * @param decryptStr 解密字符串
     */
    public String aesDecrypt(String decryptStr) {
        try {
            return AESHelper.decode(decryptStr);
        } catch (Exception e) {
            logs.write(e, "AES解密");
        }
        return "";
    }

    //endregion

    //region Cookie

    /**
     * 获得用户sid
     */
    public String getSidCookie() {
        return WebHelper.getCookieValue(request, "cwmsid");
    }

    /**
     * 设置用户sid
     *
     * @param sid sessioid
     */
    public void setSidCookie(HttpServletResponse response, String sid) {
        WebHelper.setCookie(response, "cwmsid", sid);
    }

    /**
     * 获得用户id
     */
    public Integer getUidCookie() {
        return TypeHelper.stringToInt(getCWMCookie("uid"), -1);
    }

    /**
     * 设置用户id
     *
     * @param uid uid
     */

    public void setUidCookie(HttpServletResponse response, String uid) {

        WebHelper.setCookie(response, "uid", uid);

    }

    /**
     * 获得cookie密码
     */
    public String getCookiePassword() {
        return WebHelper.urlDecode(getCWMCookie("password"));
    }


    /**
     * 获得cookie密码
     *
     * @param cookiePassword cookie密码
     */
    public String decryptCookiePassword(String cookiePassword) {
        try {


            return aesDecrypt(cookiePassword).trim();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 设置cookie密码
     *
     * @param response response
     * @param password 密码
     */
    public void setCookiePassword(HttpServletResponse response, String password) {
        try {
            setCWMCookie(response, "password", WebHelper.urlEncode(aesEncrypt(password)));
        } catch (Exception ignored) {

        }
    }

    /**
     * 清空用户
     *
     * @param response response
     */
    public void clearUserCooke(HttpServletResponse response) {


        WebHelper.removeCookie(response, "userinfo");
        WebHelper.removeCookie(response, "uid");
        WebHelper.removeCookie(response, "password");


    }


    /**
     * 设置用户
     *
     * @param response     response
     * @param partUserInfo 用户信息
     * @param expires      过期时间
     */
    public void setUserCookie(HttpServletResponse response, PartUserInfo partUserInfo, Integer expires) {

        String json = JsonHelper.object2json(partUserInfo).toString();

        setCWMCookie(response, "userinfo", WebHelper.urlEncode(json), expires);
        setUidCookie(response, partUserInfo.getUid());
        try {
            setCookiePassword(response, partUserInfo.getPassword());
        } catch (Exception ignored) {
        }

//
//        if (cookie == null)
//            cookie=new HttpCookie("cwm");
//
//        cookie.Values["uid"]=partUserInfo.getUid().toString();
//        cookie.Values["password"]=WebHelper.urlEncode(aesEncrypt(partUserInfo.Password));
//        if (expires > 0) {
//            cookie.Values["expires"]=expires.ToString();
//            cookie.Expires=DateTime.Now.AddDays(expires);
//        }
//        String cookieDomain=CWMConfig.MallConfig.CookieDomain;
//        if (cookieDomain.Length != 0)
//            cookie.Domain=cookieDomain;
//
//        HttpContext.Current.Response.AppendCookie(cookie);
    }

    @Test
    public void test2(HttpServletResponse response) {

        //setUserCookie(response, new PartUserInfo("yjwwtu", "123456"), 5000);


        setUidCookie(response, String.valueOf(2));

    }


    /// <summary>
    /// 获得cookie
    /// </summary>
    /// <param name="key">键</param>
    /// <returns></returns>

    /**
     * 获得cookie
     *
     * @param key 键
     */
    public String getCWMCookie(String key) {
        return WebHelper.getCookieValue(request, key);
    }

    /**
     * 设置cookie
     *
     * @param key   键
     * @param value 值
     */
    public void setCWMCookie(HttpServletResponse response, String key, String value) {
        WebHelper.setCookie(response, key, value);
    }

    /**
     * 设置cookie
     *
     * @param key    键
     * @param value  值
     * @param expire 过期时间
     */
    public void setCWMCookie(HttpServletResponse response, String key, String value, Integer expire) {
        WebHelper.setCookie(response, key, value, expire);
    }

    /// <summary>
    /// 获得访问referer
    /// </summary>
    public String getRefererCookie() {
        String referer = "/";
        try {

            referer = WebHelper.urlDecode(WebHelper.getCookieValue(request, "referer"));
            if (referer.length() <= 0) {
                referer = "/";
            }
        } catch (Exception ignored) {

        }
        return referer;
    }


    /**
     * 设置访问referer
     *
     * @param response response
     * @param url      url地址
     */
    public void setRefererCookie(HttpServletResponse response, String url) {
        WebHelper.setCookie(response, "referer", WebHelper.urlEncode(url));
    }

    /**
     * 获得后台访问referer
     */
    public String getAdminRefererCookie() {
        return WebHelper.urlDecode(getAdminRefererCookie("/admin/runinfo.html"));
    }


    /**
     * 获得后台访问referer
     *
     * @param defaultUrl 默认地址
     */
    public String getAdminRefererCookie(String defaultUrl) {
        String adminReferer = defaultUrl;
        try {
            adminReferer = WebHelper.urlDecode(WebHelper.getCookieValue(request, "adminreferer"));
            if (adminReferer.length() == 0) {
                adminReferer = defaultUrl;
            }
        } catch (Exception ignored) {
        }

        return adminReferer;
    }


    /**
     * 设置后台访问referer
     *
     * @param url url地址
     */
    public void setAdminRefererCookie(HttpServletResponse response, String url) {
        WebHelper.setCookie(response, "adminreferer", WebHelper.urlEncode(url));
    }

    /**
     * 获得店铺后台访问referer
     */
    public String getStoreAdminRefererCookie() {
        return WebHelper.urlDecode(getStoreAdminRefererCookie("/storeadmin/runinfo.html"));
    }

    /**
     * 获得后台访问refere
     *
     * @param defaultUrl 默认地址
     */
    public String getStoreAdminRefererCookie(String defaultUrl) {
        String adminReferer = defaultUrl;
        try {
            adminReferer = WebHelper.urlDecode(WebHelper.getCookieValue(request, "storereferer"));
            if (adminReferer.length() == 0) {
                adminReferer = defaultUrl;
            }
        } catch (Exception ignored) {

        }
        return adminReferer;
    }

    /**
     * 设置店铺后台访问referer
     *
     * @param url url地址
     */
    public void setMobileRefererCookie(HttpServletResponse response, String url) {
        WebHelper.setCookie(response, "mobilereferer", WebHelper.urlEncode(url));
    }

    /**
     * 获得店铺后台访问referer
     */
    public String getMobileRefererCookie() {


        return WebHelper.urlDecode(getMobileRefererCookie("/mob/"));
    }


    /**
     * 获得后台访问referer
     *
     * @param defaultUrl 默认地址
     */
    public String getMobileRefererCookie(String defaultUrl) {

        try {

            String adminReferer = WebHelper.urlDecode(WebHelper.getCookieValue(request, "mobilereferer"));
            if (adminReferer.length() == 0) {
                adminReferer = defaultUrl;
            }
            return adminReferer;
        } catch (Exception ignored) {
        }

        return defaultUrl;
    }


    /**
     * 设置微信访问referer
     */
    public void setWechatRefererCookie(HttpServletResponse response, String url) {

        try {
            WebHelper.setCookie(response, "wechatreferer", url);
        } catch (Exception ex) {
            logs.write(ex, "设置微信访问referer");
        }
    }

    /**
     * 获得微信访问referer
     */
    public String getWechatRefererCookie() {


        return WebHelper.urlDecode(getWechatRefererCookie("/wechat/index"));
    }

    /**
     * 获得微信访问referer
     *
     * @param defaultUrl 默认地址
     */
    public String getWechatRefererCookie(String defaultUrl) {

        try {

            String adminReferer = WebHelper.urlDecode(WebHelper.getCookieValue(request, "wechatreferer"));
            if (adminReferer.length() == 0) {
                adminReferer = defaultUrl;
            }
            return adminReferer;
        } catch (Exception ignored) {
        }

        return defaultUrl;
    }


    /**
     * 设置代理后台访问referer
     *
     * @param url url地址
     */
    public void setAgentRefererCookie(HttpServletResponse response, String url) {
        WebHelper.setCookie(response, "agentereferer", WebHelper.urlEncode(url));
    }

    /**
     * 获取代理的cookie
     *
     * @return
     */
    public String getAgentRefererCookie() {
        return getAgentRefererCookie("/agent/index");
    }

    /**
     * 获取代理的cookie
     *
     * @param defaultUrl 默认地址
     * @return
     */
    public String getAgentRefererCookie(String defaultUrl) {
        try {

            String agebtReferer = WebHelper.urlDecode(WebHelper.getCookieValue(request, "agentereferer"));
            if (agebtReferer.length() == 0) {
                agebtReferer = defaultUrl;
            }
            return agebtReferer;
        } catch (Exception ignored) {
        }

        return defaultUrl;

    }

    /**
     * 获取
     */
    public String getRawUrl() {
        return WebHelper.getRawUrl(request);
    }


    //endregion


    //region 获取路由数据


    /**
     * 获得路由中的值
     *
     * @param key 关键词
     * @return int
     */
    public Integer getParameterInt(String key) {
        return getParameterInt(key, 0);
    }


    /**
     * 获得路由中的值
     *
     * @param key          关键词
     * @param defaultValue 默认值
     * @return int
     */
    public Integer getParameterInt(String key, Integer defaultValue) {
        return TypeHelper.stringToInt(request.getParameter(key), defaultValue);
    }


    /**
     * 获得路由中的值
     *
     * @param key 关键词
     * @return int
     */
    public String getParameterString(String key) {
        return getParameterString(key, "");
    }


    /**
     * 获得路由中的值
     *
     * @param key          关键词
     * @param defaultValue 默认值
     * @return int
     */
    public String getParameterString(String key, String defaultValue) {
        String str = request.getParameter(key);

        if (StringHelper.isBlank(str)) {
            return defaultValue;
        }
        return str.toString();
    }


    /**
     * 获取用户信息
     */
    public Integer getParameterUid() {
        return getParameterInt("uid", 0);
    }

    /**
     * 获取用户token
     */
    public String getParameterToken() {
        return getParameterString("token", "");
    }

    /**
     * 获取机器编码
     */
    public String getParameterSN() {

        try {
            return getParameterString("sn", "");
        } catch (Exception ex) {
            logs.write(ex, "获取机器编码");
        }
        return "";

    }

    //endregion


    //region 获取header中的信息

    /**
     * 获取数据验证头
     */
    public String getApiTokenHeader() {

        return WebHelper.getApiTokenHeader(request);

    }


    /**
     * 获取数据验证头
     */
    public String getApiOpenIdHeader() {
        String s = WebHelper.getApiOpenIdHeader(request);

        if (StringHelper.IsNullOrWhiteSpace(s)) {
            s = "";
        }

        return s;
    }

    /**
     * 获取APIKEY验证头
     */
    public String getApiKeyHeader() {

        String s = WebHelper.getApiKeyHeader(request);
        if (StringHelper.IsNullOrWhiteSpace(s)) {
            s = "";
        }

        return s;
    }


    /**
     * 获取数据验证头
     */
    public String getApiSecretHeader() {

        String s = WebHelper.getApiSecretHeader(request);
        if (StringHelper.IsNullOrWhiteSpace(s)) {
            s = "";
        }

        return s;
    }


    /**
     * 获取数据OPENID头
     */
    public String getOpenIdHeader() {

        String s = WebHelper.getOpenIdHeader(request);
        if (StringHelper.IsNullOrWhiteSpace(s)) {
            s = "";
        }

        return s;
    }

    /**
     * 获取SessionId
     */
    public String getSessionIdHeader() {

        String s = WebHelper.getSessionIdHeader(request);
        if (StringHelper.IsNullOrWhiteSpace(s)) {
            s = "";
        }

        return s;


    }

    /**
     * 获取用户代理信息
     */
    public String getUserAgent() {
        String s = WebHelper.getUserAgent(request);
        if (StringHelper.IsNullOrWhiteSpace(s)) {
            s = "";
        }

        return s;
    }

    /**
     * 获取机器IP
     */
    public String getIP() {

        try {
            return WebHelper.getIP(request);
        } catch (Exception ex) {
            logs.write(ex, "获取机器IP");
        }

        return "127.0.0.1";

    }

    /**
     * 解析accessToken
     *
     * @param token token
     * @return
     */
    public static AccessToken decryptAccessToken(String token) {

        AccessToken tokenInfo = null;

        if (StringHelper.isNullOrWhiteSpace(token)) {
            return null;
        }

        try {
            String postStr = AESHelper.decode(token);
            tokenInfo = JSON.parseObject(postStr, AccessToken.class);

        } catch (Exception ex) {

        }

        return tokenInfo;
    }

    /**
     * 创过token用户
     *
     * @param uid       用户uid
     * @param salt      盐值
     * @param creatTime 过期时间
     * @return
     */
    public static String createAccessToken(String uid, String salt, Integer creatTime) {

        String token = "";

        try {

            AccessToken userToken = new AccessToken(uid, salt, creatTime);
            String content = JSON.toJSONString(userToken);

            token = AESHelper.encode(content);

        } catch (Exception ignored) {


        }

        return token;
    }

    public static void main(String[] args) {
        String s = createAccessToken("40289381665cbe1c01665cc884b70001", "123456", 0);

        // System.out.println(s);
    }

    //endregion
}
