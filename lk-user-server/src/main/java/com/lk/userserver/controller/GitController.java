package com.lk.userserver.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("gitconfig")
public class GitController {
    @Value("${data.env}")
    private String env;

    @Value("${data.user.username}")
    private String username;

    @Value("${data.user.password}")
    private String password;

    @GetMapping(value = "autoShow")
    public Object autoShow(){
        Map<String, Object> map = new HashMap<>();
        map.put("env",env);
        map.put("username",username);
        map.put("password",password);
        return map;
    }
}
