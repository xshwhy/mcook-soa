package com.iotmars.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: xsh
 * @date: 2021/1/27 9:20
 */
@Data
@ConfigurationProperties(prefix = "user")
public class UserConfig {

    private String name;





}
