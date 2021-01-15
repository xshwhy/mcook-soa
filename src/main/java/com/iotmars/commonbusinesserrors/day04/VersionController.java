package com.iotmars.commonbusinesserrors.day04;

import com.iotmars.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xsh
 * @date: 2021/1/8 11:33
 */
@RestController
public class VersionController {


    @Autowired
    private VersionService versionService;

    @GetMapping(value = "/createMainVersion")
    public int createMainVersion() {

        /*try {
            versionService.createMainRightVersion();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        versionService.createMainRightVersion();
        return versionService.getVersionName();

    }

}
