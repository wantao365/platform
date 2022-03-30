package com.platform.plugins.license;

import com.platform.plugins.license.entity.LicenseCheckModel;
import com.platform.plugins.license.entity.LicenseCreatorParam;
import com.platform.plugins.license.utils.LicenseUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 测试
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println(LicenseUtils.getServerInfos("windows"));

        try {
            LicenseCreatorParam param = new LicenseCreatorParam();
            param.setSubject("wantao");
            param.setPrivateAlias("privateKey");
            param.setKeyPass("private_password1234");
            param.setStorePass("public_password1234");
            param.setLicensePath("D:\\License\\license.lic");
            param.setPrivateKeysStorePath("D:\\License\\privateKeys.keystore");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            param.setIssuedTime(sdf.parse("2022-3-25 00:00:01"));
            param.setExpiryTime(sdf.parse("2022-3-30 17:05:00"));
            param.setConsumerType("user");
            param.setConsumerAmount(1);
            param.setDescription("测试证书发布");
            LicenseCheckModel model = new LicenseCheckModel();
            List<String> ipAddress = new ArrayList<>();
            ipAddress.add("192.168.8.106");
            ipAddress.add("192.168.65.1");
            ipAddress.add("192.168.1.167");
            ipAddress.add("192.168.6.199");
            model.setIpAddress(ipAddress);
            List<String> macAddress = new ArrayList<>();
            macAddress.add("8C-C8-4B-16-E0-83");
            macAddress.add("00-50-56-C0-00-01");
            macAddress.add("B4-A9-FC-A6-16-21");
            macAddress.add("00-50-56-C0-00-08");
            model.setMacAddress(macAddress);
            model.setCpuSerial("BFEBFBFF000706E5");
            model.setMainBoardSerial("LR0C74T3");
            param.setLicenseCheckModel(model);
            System.out.println(LicenseUtils.generateLicense(param));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
