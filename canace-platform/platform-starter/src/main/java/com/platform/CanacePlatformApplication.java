package com.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * TODO
 *  平台启动类
 * @author wantao
 * @version 1.0
 * @date 2022/3/29
 */
@EnableScheduling
@SpringBootApplication
public class CanacePlatformApplication {

    public static void main(String[] args){
        SpringApplication.run(CanacePlatformApplication.class, args);
    }

}
