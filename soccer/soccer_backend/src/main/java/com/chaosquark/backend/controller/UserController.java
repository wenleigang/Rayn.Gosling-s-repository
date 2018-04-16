package com.chaosquark.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @RequestMapping(value = "/getUserByUsername", method = RequestMethod.POST)
    public String getUserByUsername(String username) {
        return username;
    }
}
