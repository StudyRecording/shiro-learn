package com.example.demo.config;

import com.example.demo.shiro.cache.RedisCacheManager;
import com.example.demo.shiro.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> map = new HashMap<>();
        map.put("/register.jsp", "anon");
        map.put("/login.jsp", "anon");
        map.put("/user/login", "anon");
        map.put("/user/register", "anon");
        map.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        // shiroFilterFactoryBean.setLoginUrl("./login.jsp");

        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;
    }

    @Bean
    public Realm realm() {
        CustomerRealm customerRealm = new CustomerRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(credentialsMatcher);

        // 设置缓存
        customerRealm.setCachingEnabled(true);
        customerRealm.setCacheManager(new RedisCacheManager());
        customerRealm.setAuthenticationCachingEnabled(true);
        customerRealm.setAuthenticationCacheName("authenticationCache");
        customerRealm.setAuthorizationCachingEnabled(true);
        customerRealm.setAuthorizationCacheName("authorizationCache");

        return customerRealm;
    }
}
