package com.cqwo.base.web.framework.filter;

import com.cqwo.base.core.helper.StringHelper;
import com.cqwo.base.core.helper.WebHelper;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by pangkunkun on 2017/11/18.
 */
public class ApiAccessControlFilter extends FormAuthenticationFilter {

    @Override
    public String getLoginUrl() {
        return "/api/error";
    }

    private static final Logger log = LoggerFactory.getLogger(ApiAccessControlFilter.class);


    /**
     * 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     * onAccessDenied是否执行取决于isAccessAllowed的值，如果返回true则onAccessDenied不会执行；如果返回false，执行onAccessDenied
     * 如果onAccessDenied也返回false，则直接返回，不会进入请求的方法（只有isAccessAllowed和onAccessDenied的情况下）
     */
    @Override
    public boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if (request == null || response == null) {
            return false;
        }


        HttpServletRequest hsr = (HttpServletRequest) request;

        String apiKey = WebHelper.getApiKeyHeader(hsr);
        String apiSecret = WebHelper.getApiSecretHeader(hsr);
        //String accessToken = WebHelper.getApiTokenHeader(hsr);


        log.info("当前用户正在访问的 url2 => " + hsr.getHeader("user-agent"));
        log.info("当前用户正在访问的 X-CWMAPI-ApiKey => " + apiKey);


        //WebHelper.getApiKeyHeader(request,"uid");


        // System.out.println("apiKey:" + apiKey);
        // System.out.println("apiSecret:" + apiSecret);

        if (StringHelper.IsNullOrWhiteSpace(apiKey)) {
            onLoginFail(response);
            return false;
        }

        return true;
    }

    /**
     * 登录失败
     */
    private void onLoginFail(ServletResponse response) throws IOException {
        log.info("设置返回");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        httpResponse.getWriter().write("login error");
    }

    /**
     * TODO 跨域请求
     */
    private void dealCrossDomain() {

    }
}
