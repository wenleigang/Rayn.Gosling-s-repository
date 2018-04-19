package com.chaosquark.backend.repository;

import com.chaosquark.backend.entity.User;
import com.chaosquark.backend.common.tkmapper.MyTkMapper;
import org.springframework.stereotype.Component;

/**
 * @ClassName: UserRepository
 * @Description: 有关用户操作的数据访问层接口描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/18/018 10:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/18/018 10:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
public interface UserRepository extends MyTkMapper<User> {

    /**
     * @method： getUserByUsername
     * @description: 根据用户名查询用户对象
     * @date: 2018/4/18/018 10:42
     * @author: Rayn.Gosling
     * @param： 用户名
     * @return： 用户对象
     */
    User getUserByUsername(String username);
}
