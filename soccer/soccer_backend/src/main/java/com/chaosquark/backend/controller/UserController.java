package com.chaosquark.backend.controller;

import com.chaosquark.backend.common.enums.ResponseStatusEnum;
import com.chaosquark.backend.entity.BizException;
import com.chaosquark.backend.entity.User;
import com.chaosquark.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserByUsername", method = RequestMethod.POST)
    @ResponseBody
    public User getUserByUsername(String username) {
        if(username.equals("1")) {
            throw new BizException(ResponseStatusEnum.PARAMETER_VALUE_ILLEGAL);
        }

        if(username.equals("2")) {
            throw new NullPointerException();
        }

        User user = userService.getUserByUsername(username);
        return user;
    }
}
