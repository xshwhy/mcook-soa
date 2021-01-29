package com.iotmars.controller;

import com.iotmars.po.UserPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xsh
 * @date: 2021/1/25 14:35
 */
@Api(tags = {"自定义参数校验注解"})
@RestController
public class UserController {

    @ApiOperation(value = "参数校验", notes = "自定义")
    @PostMapping(value = "/user")
    public Object test(@Validated @RequestBody UserPO user) {
        return "hello world";
    }

    @ApiOperation(value = "参数校验", notes = "自定义")
    @PostMapping(value = "/user22")
    public Object test1() {
        return "hello world";
    }


}
