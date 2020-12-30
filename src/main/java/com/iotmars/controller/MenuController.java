package com.iotmars.controller;

import com.iotmars.service.MenuService;
import com.iotmars.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xsh
 * @date: 2020/12/28 10:22
 */
@Api(tags = {"同步es"})
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "同步es", notes = "es")
    @GetMapping(value = "/findMenuInPublish")
    public void findMenuInPublish() {
        menuService.findMenuInPublish();
    }


    @ApiOperation(value = "关键词查询", notes = "es")
    @GetMapping(value = "/searchMenu")
    public Result searchMenu(@RequestParam(value = "keyWord",required = false) String keyWord,
                             @RequestParam(value = "page",required = false) Integer page,
                             @RequestParam(value = "pageSize",required = false) Integer pageSize) {
     return  menuService.searchMenu(keyWord,page,pageSize);
    }



}
