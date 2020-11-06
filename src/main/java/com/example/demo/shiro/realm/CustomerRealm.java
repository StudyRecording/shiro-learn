package com.example.demo.shiro.realm;

import com.example.demo.entity.Roles;
import com.example.demo.entity.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.utl.ApplicationContextUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.List;

public class CustomerRealm extends AuthorizingRealm {
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();

        UserService userService = (UserService) ApplicationContextUtil.getBean("userServiceImpl");
        RoleService roleService = (RoleService) ApplicationContextUtil.getBean("roleServiceImpl");
        User user = userService.selectUserAndRolesByUsername(username);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            for (Roles role: user.getRoles()) {
                info.addRole(role.getName());

                // 获取权限
                List<Roles> roles = roleService.selectRoleAndPermByRoleId(role.getId());
                for (Roles r : roles) {
                    r.getPerms().forEach(item -> info.addStringPermission(item.getName()));
                }
            }

            return info;
        }

        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();

        UserService userService = (UserService) ApplicationContextUtil.getBean("userServiceImpl");

        User user = userService.selectByUsername(username);
        if (user != null) {
            return new SimpleAuthenticationInfo(username,
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),
                    this.getName());
        }

//        if ("xiaochen".equals(username)) {
//            return new SimpleAuthenticationInfo(username, "123", this.getName());
//        }

        return null;
    }
}
