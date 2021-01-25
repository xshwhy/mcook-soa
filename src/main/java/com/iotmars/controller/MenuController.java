package com.iotmars.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.client.exception.OceanException;
import com.iotmars.service.MenuService;
import com.iotmars.utils.Result;
import com.umeng.uapp.param.*;
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


    public void umengUappGetAppCount(ApiExecutor apiExecutor) {
        UmengUappGetAppCountParam param = new UmengUappGetAppCountParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        try {
            UmengUappGetAppCountResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
    }


    public void umengUappGetLaunchesByChannelOrVersion(ApiExecutor apiExecutor) {
        UmengUappGetLaunchesByChannelOrVersionParam param = new UmengUappGetLaunchesByChannelOrVersionParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey("");
        param.setStartDate("2018-01-01");
        param.setEndDate("2018-01-01");
        param.setPeriodType("daily");
        param.setChannels("App%20Store");
        param.setVersions("1.0.0");

        try {
            UmengUappGetLaunchesByChannelOrVersionResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
    }


    public void umengUappGetLaunches(ApiExecutor apiExecutor) {
        UmengUappGetLaunchesParam param = new UmengUappGetLaunchesParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey("");
        param.setStartDate("2018-01-01");
        param.setEndDate("2018-01-01");
        param.setPeriodType("daily");

        try {
            UmengUappGetLaunchesResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
    }

    public void umengUappEventGetUniqueUsers(ApiExecutor apiExecutor) {
        UmengUappEventGetUniqueUsersParam param = new UmengUappEventGetUniqueUsersParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey("");
        param.setStartDate("2018-01-01");
        param.setEndDate("2018-01-01");
        param.setEventName("");

        try {
            UmengUappEventGetUniqueUsersResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
    }


    public void umengUappGetNewAccounts(ApiExecutor apiExecutor) {
        UmengUappGetNewAccountsParam param = new UmengUappGetNewAccountsParam();
        // 测试环境只支持http
        // param.getOceanRequestPolicy().setUseHttps(false);
        param.setAppkey("");
        param.setStartDate("2018-01-01");
        param.setEndDate("");
        param.setPeriodType("");
        param.setChannel("");

        try {
            UmengUappGetNewAccountsResult result = apiExecutor.execute(param);
            System.out.println(JSONObject.toJSONString(result));
        } catch (OceanException e) {
            System.out.println("errorCode=" + e.getErrorCode() + ", errorMessage=" + e.getErrorMessage());
        }
    }



    public static void main(String[] args) {
        // 请替换apiKey和apiSecurity
        ApiExecutor apiExecutor = new ApiExecutor("7466414", "qfjUwausSc");
        apiExecutor.setServerHost("gateway.open.umeng.com");

        MenuController testOpenAPI = new MenuController();
//        testOpenAPI.umengUappEventGetUniqueUsers(apiExecutor);

//        testOpenAPI.umengUappGetLaunchesByChannelOrVersion(apiExecutor);

//        testOpenAPI.umengUappGetNewAccounts(apiExecutor);

//        testOpenAPI.umengUappGetLaunches(apiExecutor);

        testOpenAPI.umengUappGetAppCount(apiExecutor);
    }














}
