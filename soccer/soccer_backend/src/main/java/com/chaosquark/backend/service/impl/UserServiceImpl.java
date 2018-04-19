package com.chaosquark.backend.service.impl;

import com.chaosquark.backend.entity.User;
import com.chaosquark.backend.repository.UserRepository;
import com.chaosquark.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: UserServiceImpl
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/18/018 10:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/18/018 10:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        return user;
    }
}
