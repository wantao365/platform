package com.platform.plugins.license.core.listener;

import com.platform.plugins.license.entity.LicenseVerifyParam;
import com.platform.plugins.license.verify.LicenseVerify;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * TODO
 * 在项目启动时安装证书
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
@Slf4j
@Component
public class LicenseCheckListener implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 证书subject
     */
    @Value("${platform.license.subject}")
    private String subject;

    /**
     * 公钥别称
     */
    @Value("${platform.license.publicAlias}")
    private String publicAlias;

    /**
     * 访问公钥库的密码
     */
    @Value("${platform.license.storePass}")
    private String storePass;

    /**
     * 证书生成路径
     */
    @Value("${platform.license.licensePath}")
    private String licensePath;

    /**
     * 密钥库存储路径
     */
    @Value("${platform.license.publicKeysStorePath}")
    private String publicKeysStorePath;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //root application context 没有parent
        ApplicationContext context = event.getApplicationContext().getParent();
        if(context == null){
            if(StringUtils.isNotBlank(licensePath)){
                log.info("++++++++ 开始安装证书 ++++++++");

                LicenseVerifyParam param = new LicenseVerifyParam();
                param.setSubject(subject);
                param.setPublicAlias(publicAlias);
                param.setStorePass(storePass);
                param.setLicensePath(licensePath);
                param.setPublicKeysStorePath(publicKeysStorePath);

                LicenseVerify licenseVerify = new LicenseVerify();
                //安装证书
                licenseVerify.install(param);

                log.info("++++++++ 证书安装结束 ++++++++");
            }
        }
    }
}

