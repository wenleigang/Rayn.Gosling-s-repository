package com.chaosquark.backend.configuration;

import com.chaosquark.backend.shiro.UserAuthRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ShiroConfig
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/27/027 15:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/27/027 15:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
public class ShiroConfig {
    private final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Value("${shiro.hashAlgorithmName}")
    private String hashAlgorithmName;

    @Value("${shiro.hashIterations}")
    private int hashIterations;

    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        logger.info("-------------------自定义shiro匹配凭证器-------------------------");

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(hashAlgorithmName);
        hashedCredentialsMatcher.setHashIterations(hashIterations);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(Boolean.TRUE);
        return hashedCredentialsMatcher;
    }

    @Bean("userAuthRealm")
    public UserAuthRealm userAuthRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher hashedCredentialsMatcher){
        logger.info("---------------------给自定义shiro realm设置自定义的匹配凭证器规则--------------------------");

        UserAuthRealm userAuthRealm = new UserAuthRealm();
        userAuthRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return userAuthRealm;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("userAuthRealm") UserAuthRealm userAuthRealm) {
        logger.info("---------------------安全管理器注入自定义realm--------------------------");

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userAuthRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        logger.info("----------------------初始化shiro过滤器,注入安全管理器------------------------------");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //注意过滤器配置顺序 不能颠倒
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        filterChainDefinitionMap.put("/logout", "logout");
        // *配置不会被拦截的链接 顺序判断
        //匿名访问静态资源
        filterChainDefinitionMap.put("/static/**", "anon");
        //匿名访问登陆请求
        filterChainDefinitionMap.put("/user/login", "anon");
        //需要登陆用户
        filterChainDefinitionMap.put("/**", "authc");
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/user/noauthc");
        //配置权限不足地址
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/unauthc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 使用代理 所以要开启代码注解支持
     * @param securityManager
     * @return
     */
    @Bean("authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        logger.info("-------------------------开启shiro aop注解支持----------------------------");

        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
