package com.platform.plugins.license.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 * 自定义需要校验的License参数
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LicenseCheckModel implements Serializable {

    private static final long serialVersionUID = -6675801754349114312L;

    /**
     * 可被允许的IP地址
     */
    private List<String> ipAddress;

    /**
     * 可被允许的MAC地址
     */
    private List<String> macAddress;

    /**
     * 可被允许的CPU序列号
     */
    private String cpuSerial;

    /**
     * 可被允许的主板序列号
     */
    private String mainBoardSerial;

}
