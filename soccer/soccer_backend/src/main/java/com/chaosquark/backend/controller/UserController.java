package com.chaosquark.backend.controller;

import com.chaosquark.backend.annotation.WareResponseBody;
import com.chaosquark.backend.common.enums.ResponseStatusEnum;
import com.chaosquark.backend.entity.BizException;
import com.chaosquark.backend.entity.User;
import com.chaosquark.backend.entity.vo.ResponseVo;
import com.chaosquark.backend.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@WareResponseBody
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserByUsername", method = RequestMethod.POST)
    @ResponseBody
    public User getUserByUsername(String username) {
        logger.info("---------controller----根据用户名："+username+"查询用户信息----------------");

        if(username.equals("1")) {
            throw new BizException(ResponseStatusEnum.PARAMETER_VALUE_ILLEGAL);
        }

        if(username.equals("2")) {
            throw new NullPointerException();
        }

        User user = userService.getUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "/getUserByUsername2", method = RequestMethod.POST)
    public User getUserByUsername2(String username) {
        logger.info("---------controller----根据用户名："+username+"查询用户信息----------------");

        User user = userService.getUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVo login(User user) {
        logger.info("----------controller----执行登陆操作--------------------------------------");

        ResponseVo<Object> responseVo = null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            responseVo = new ResponseVo<>(ResponseStatusEnum.API_SUCCESS);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            responseVo = new ResponseVo<>(ResponseStatusEnum.ACCOUNT_NOT_EXIST);
        } catch (IncorrectCredentialsException e) {
            responseVo = new ResponseVo<>(ResponseStatusEnum.USER_PASSWORD_NOT_MATCH);
        } catch (Exception e) {
            responseVo = new ResponseVo<>(ResponseStatusEnum.USER_UNKNOWN_ERROR);
        }
        return responseVo;
    }

    @RequestMapping(value = "/noauthc", method = RequestMethod.GET)
    public ResponseVo noauthc() {
        return new ResponseVo(ResponseStatusEnum.USER_NOT_EXISTS);
    }

    @RequestMapping(value = "/nuauthc", method = RequestMethod.GET)
    public ResponseVo nuauthc() {
        return new ResponseVo(ResponseStatusEnum.USER_UNAUTHC);
    }

    @RequestMapping(value = "/testRole", method = RequestMethod.GET)
    @RequiresRoles("admin")
    public String testRole() {
        return "admin 才能看见的数据";
    }
}
