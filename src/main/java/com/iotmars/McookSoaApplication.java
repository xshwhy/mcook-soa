package com.iotmars;

import com.iotmars.config.UserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Administrator
 */
@EnableConfigurationProperties({UserConfig.class})
@MapperScan("com.iotmars.mapper")
@SpringBootApplication
public class McookSoaApplication {

    public static void main(String[] args) {
        SpringApplication.run(McookSoaApplication.class, args);
    }

}
