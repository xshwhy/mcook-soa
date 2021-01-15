package com.iotmars.commonbusinesserrors.day02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
/**
 * @author: xsh
 * @date: 2021/1/7 11:03
 */
@Slf4j
@RestController
@RequestMapping(value = "/synchronized")
public class SynchronizedController {


    private List<Integer> data = new ArrayList<>();

    //不涉及共享资源的慢方法
    private void slow() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    //错误的加锁方法
    @GetMapping("wrong")
    public int wrong() {
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            //加锁粒度太粗了
            synchronized (this) {
                slow();
                data.add(i);
            }
        });
        log.info("took:{}", System.currentTimeMillis() - begin);
        return data.size();
    }

    //正确的加锁方法
    @GetMapping("right")
    public int right() {
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            slow();
            //只对List加锁
            synchronized (data) {
                data.add(i);
            }
        });
        log.info("took:{}", System.currentTimeMillis() - begin);
        return data.size();
    }


}
