package com.iotmars.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author: xsh
 * @date: 2021/1/27 11:18
 */
@RestController
@RequestMapping("test")
public class TestController {


    @PostMapping
    public String add() {
        return "add";
    }

    @DeleteMapping
    public String del() {
        return "del";
    }

    @PutMapping
    public String update() {
        return "update";
    }

    @GetMapping
    public String find() {
        return "find";
    }


}
