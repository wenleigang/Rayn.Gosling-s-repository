package com.chaosquark.backend.shiro;

import com.chaosquark.backend.entity.User;
import com.chaosquark.backend.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: UserAuthRealm
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/27/027 15:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/27/027 15:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserAuthRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger(UserAuthRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("-------------------------shiro授权角色和权限信息-----------------------------");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("admin");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("-------------------------shiro认证登陆用户信息-------------------------------");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        User user = userService.getUserByUsername(usernamePasswordToken.getUsername());
        if(user == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        logger.info("-------------------------认证通过-----------------------------------");
        return authenticationInfo;
    }
}
