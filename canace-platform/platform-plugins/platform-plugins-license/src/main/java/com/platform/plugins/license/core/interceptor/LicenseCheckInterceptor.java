package com.platform.plugins.license.core.interceptor;

import com.alibaba.fastjson.JSON;
import com.platform.plugins.license.verify.LicenseVerify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 使用拦截器拦截请求，验证证书的可用性
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
@Slf4j
@Component
public class LicenseCheckInterceptor implements HandlerInterceptor {

    /**
     * 进入controller层之前拦截请求
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入拦截器，验证证书可使用性");
        LicenseVerify licenseVerify = new LicenseVerify();

        //校验证书是否有效
        boolean verifyResult = licenseVerify.verify();

        if(verifyResult){
            log.info("验证成功，证书可用");
            return true;
        }else{
            log.info("验证失败，证书无效");
            response.setCharacterEncoding("utf-8");
            Map<String,String> result = new HashMap<>(1);
            result.put("result","您的证书无效，请核查服务器是否取得授权或重新申请证书！");

            response.getWriter().write(JSON.toJSONString(result));

            return false;
        }
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("处理请求完成后视图渲染之前的处理操作");
    }

    /**
     * 视图渲染之后的操作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("视图渲染之后的操作");
    }

}

