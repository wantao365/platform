package com.platform.plugins.license.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 * License生成类需要的参数
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LicenseCreatorParam implements Serializable {

    private static final long serialVersionUID = 739856311727374862L;

    /**
     * 证书subject
     */
    private String subject;

    /**
     * 密钥别称
     */
    private String privateAlias;

    /**
     * 密钥密码（需要妥善保管，不能让使用者知道）
     */
    private String keyPass;

    /**
     * 访问秘钥库的密码
     */
    private String storePass;

    /**
     * 证书生成路径
     */
    private String licensePath;

    /**
     * 密钥库存储路径
     */
    private String privateKeysStorePath;

    /**
     * 证书生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date issuedTime = new Date();

    /**
     * 证书失效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiryTime;

    /**
     * 用户类型
     */
    private String consumerType = "user";

    /**
     * 用户数量
     */
    private Integer consumerAmount = 1;

    /**
     * 描述信息
     */
    private String description = "";

    /**
     * 额外的服务器硬件校验信息
     */
    private LicenseCheckModel licenseCheckModel;
}
