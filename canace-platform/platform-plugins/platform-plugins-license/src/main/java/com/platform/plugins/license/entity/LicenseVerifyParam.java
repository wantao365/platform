package com.platform.plugins.license.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * TODO
 * License校验类需要的参数
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LicenseVerifyParam implements Serializable {

    private static final long serialVersionUID = 8998338868502377086L;

    /**
     * 证书subject
     */
    private String subject;

    /**
     * 公钥别称
     */
    private String publicAlias;

    /**
     * 访问公钥库的密码
     */
    private String storePass;

    /**
     * 证书生成路径
     */
    private String licensePath;

    /**
     * 密钥库存储路径
     */
    private String publicKeysStorePath;


    /**
     * 额外的服务器硬件校验信息
     */
    private LicenseCheckModel licenseCheckModel;
}

