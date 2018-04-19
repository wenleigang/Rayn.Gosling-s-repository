package com.chaosquark.backend.service;

import com.chaosquark.backend.entity.User;

/**
 * @ClassName: UserService
 * @Description: 有关于用户的业务层接口描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/18/018 10:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/18/018 10:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UserService {

    /**
     * @method： getUserByUsername
     * @description 根据用户名获取用户信息
     * @date: 2018/4/18/018 10:36
     * @author: Rayn.Gosling
     * @param： 用户名
     * @return： 用户对象
     */
    User getUserByUsername(String username);
}
