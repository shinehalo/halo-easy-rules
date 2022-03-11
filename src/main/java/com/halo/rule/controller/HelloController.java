package com.halo.rule.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author halo
 * @description
 * @date 2022/03/11
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/sayHello")
    public String sayHello() {
        return "Say Hello!!!";
    }
}
