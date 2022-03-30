package com.platform.plugins.license.utils;

import com.platform.plugins.license.core.AbstractServerInfos;
import com.platform.plugins.license.core.linux.LinuxServerInfos;
import com.platform.plugins.license.core.win.WindowsServerInfos;
import com.platform.plugins.license.entity.LicenseCheckModel;
import com.platform.plugins.license.entity.LicenseCreatorParam;
import com.platform.plugins.license.greator.LicenseCreator;
import io.micrometer.core.instrument.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
public class LicenseUtils {

    /**
     * 获取服务器硬件信息
     * @param osName 操作系统类型，如果为空则自动判断
     * @return com.ccx.models.license.LicenseCheckModel
     */
    public static LicenseCheckModel getServerInfos(String osName) {
        //操作系统类型
        if(StringUtils.isBlank(osName)){
            osName = System.getProperty("os.name");
        }
        osName = osName.toLowerCase();

        AbstractServerInfos abstractServerInfos = null;

        //根据不同操作系统类型选择不同的数据获取方法
        if (osName.startsWith("windows")) {
            abstractServerInfos = new WindowsServerInfos();
        } else if (osName.startsWith("linux")) {
            abstractServerInfos = new LinuxServerInfos();
        }else{//其他服务器类型
            abstractServerInfos = new LinuxServerInfos();
        }
        return abstractServerInfos.getServerInfos();
    }

    /**
     * 生成证书
     * @param param 生成证书需要的参数，如：{"subject":"ccx-models","privateAlias":"privateKey","keyPass":"5T7Zz5Y0dJFcqTxvzkH5LDGJJSGMzQ","storePass":"3538cef8e7","licensePath":"C:/Users/zifangsky/Desktop/license.md","privateKeysStorePath":"C:/Users/zifangsky/Desktop/privateKeys.keystore","issuedTime":"2018-04-26 14:48:12","expiryTime":"2018-12-31 00:00:00","consumerType":"User","consumerAmount":1,"description":"这是证书描述信息","licenseCheckModel":{"ipAddress":["192.168.245.1","10.0.5.22"],"macAddress":["00-50-56-C0-00-01","50-7B-9D-F9-18-41"],"cpuSerial":"BFEBFBFF000406E3","mainBoardSerial":"L1HF65E00X9"}}
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String,Object> generateLicense(LicenseCreatorParam param) {
        Map<String,Object> resultMap = new HashMap<>(2);

        if(StringUtils.isBlank(param.getLicensePath())){
            param.setLicensePath("C:/license.md");
        }

        LicenseCreator licenseCreator = new LicenseCreator(param);
        boolean result = licenseCreator.generateLicense();

        if(result){
            resultMap.put("result","ok");
            resultMap.put("msg",param);
        }else{
            resultMap.put("result","error");
            resultMap.put("msg","证书文件生成失败！");
        }
        return resultMap;
    }

}
