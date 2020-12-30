package com.iotmars.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author: xsh
 * @date: 2020/11/14 14:32
 */
@Service
@Aspect
@Slf4j
@Profile({"dev", "test"})
public class LogInterceptor {

    @Around("execution(* com.iotmars.controller.*.*(..)) " +
            " || execution(* com.iotmars.service.*.*(..)) " +
            " || execution(* com.iotmars.mapper.*.*(..)) ")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        Object result = pjp.proceed();

        try {
            Duration duration = Duration.between(start, LocalDateTime.now());
            long times = duration.toNanos() / 1000000;
            Object[] args = pjp.getArgs();
            ObjectMapper mapper = new ObjectMapper();

            if (times > 500) {
                log.error("{}--执行时间:{}毫秒, args:{}", pjp.getSignature().toString(), times, mapper.writeValueAsString(args));
            } else if (times > 100) {
                log.info("{}--执行时间:{}毫秒, args:{}", pjp.getSignature().toString(), times, mapper.writeValueAsString(args));
            } else {
                log.debug("{}--执行时间:{}毫秒, args:{}", pjp.getSignature().toString(), times, mapper.writeValueAsString(args));
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return result;
    }
}
