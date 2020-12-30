package com.iotmars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@MapperScan("com.iotmars.mapper")
@SpringBootApplication
public class McookSoaApplication {

    public static void main(String[] args) {
        SpringApplication.run(McookSoaApplication.class, args);
    }

}
