package com.platform.plugins.license.core.config;

import com.platform.plugins.license.core.interceptor.LicenseCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * TODO
 * 拦截器配置
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private LicenseCheckInterceptor licenseCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加要拦截的url
        registry.addInterceptor(licenseCheckInterceptor)
                // 拦截的路径
                .addPathPatterns("/**");
        // 放行的路径
//                .excludePathPatterns("/admin/login");
    }
}
