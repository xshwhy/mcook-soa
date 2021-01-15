package com.iotmars.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iotmars.mapper.VersionMapper;
import com.iotmars.po.VersionPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: xsh
 * @date: 2021/1/8 11:19
 */
@Slf4j
@Service
public class VersionService {

    @Autowired
    private VersionMapper versionMapper;

    @Autowired
    private OldVersionService oldVersionService;

    @Transactional
    public void createMainRightVersion() {

        createVersion();
        try {
            oldVersionService.createOldVersion();
        } catch (Exception e) {
            // 捕获异常，防止主方法回滚
            log.error("111",e.getMessage());
        }


    }




    private void createVersion() {
        log.info("添加主方法");
        VersionPO version = new VersionPO();
        version.setVersion("1.00");
        version.setDeviceType("Q7");
        versionMapper.insert(version);
    }

    public int getVersionName() {
        return versionMapper.selectCount(new QueryWrapper<VersionPO>()
                .eq("device_type", "Q7"));
    }






}
