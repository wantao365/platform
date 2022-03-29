package com.platform.plugins.license.core.singleton;

import com.platform.plugins.license.verify.CustomLicenseManager;
import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

/**
 * TODO
 * de.schlichtherle.license.LicenseManager的单例
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
public class LicenseManagerHolder {

    private static volatile LicenseManager LICENSE_MANAGER;

    public static LicenseManager getInstance(LicenseParam param){
        if(LICENSE_MANAGER == null){
            synchronized (LicenseManagerHolder.class){
                if(LICENSE_MANAGER == null){
                    LICENSE_MANAGER = new CustomLicenseManager(param);
                }
            }
        }

        return LICENSE_MANAGER;
    }

}
