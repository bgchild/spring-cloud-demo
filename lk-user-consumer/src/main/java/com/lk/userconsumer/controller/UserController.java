package com.lk.userconsumer.controller;

import com.lk.userconsumer.pojo.User;
import com.lk.userconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consume")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> consume(@RequestParam("ids") List<Long> ids) {
        return userService.queryUserByIds(ids);
    }
}
