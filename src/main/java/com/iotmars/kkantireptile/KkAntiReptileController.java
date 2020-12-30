package com.iotmars.kkantireptile;

import cn.keking.anti_reptile.annotation.AntiReptile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xsh
 * @date: 2020/12/24 9:38
 */
@RestController
public class KkAntiReptileController {

    @AntiReptile
    @GetMapping(value = "/admin")
    public String admin() {
        System.out.println(Thread.currentThread().getName());
        return "Hello,World";
    }


    public static void main(String[] args) {

    }


}
