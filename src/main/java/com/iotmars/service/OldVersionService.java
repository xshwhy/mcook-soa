package com.iotmars.service;

import com.iotmars.mapper.VersionMapper;
import com.iotmars.po.VersionPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: xsh
 * @date: 2021/1/8 11:19
 */
@Slf4j
@Service
public class OldVersionService {

    @Autowired
    private VersionMapper versionMapper;


    /**
     * 事务传播策略，也就是执行这个方法需要开启新的事务，并挂起当前事务
     *
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional
    public void createOldVersion() {
        log.info("添加子方法");
        VersionPO version = new VersionPO();
        version.setVersion("2.00");
        version.setDeviceType("Q7");
        versionMapper.insert(version);
        throw new RuntimeException("invalid status");
    }



}
