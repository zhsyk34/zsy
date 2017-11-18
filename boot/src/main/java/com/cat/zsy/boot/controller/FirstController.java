package com.cat.zsy.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class FirstController {

    @GetMapping("world")
    public String world() {
        return "world";
    }
}
