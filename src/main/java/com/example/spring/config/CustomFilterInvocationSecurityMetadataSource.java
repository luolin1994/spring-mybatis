package com.example.spring.config;

import com.example.spring.bean.Permission;
import com.example.spring.bean.Role;
import com.example.spring.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.security.access.SecurityConfig;

import java.util.Collection;
import java.util.List;

/**
 * 根据用户传来的请求地址，分析出所需要的角色
 */

@Component
public class CustomFilterInvocationSecurityMetadataSource  implements FilterInvocationSecurityMetadataSource {

    @Autowired
    PermissionMapper permissionMapper;
    AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation)object).getRequestUrl();
        //获取当前请求需要的角色信息
        List<Permission> permissions = permissionMapper.getAllPermissionsWithRole();
        for(Permission permission:permissions){
            if(antPathMatcher.match(permission.getUrl(),requestUrl) && permission.getRoles().size()>0){
                List<Role> roles = permission.getRoles();
                //定义一个数组来接收能访问该资源的角色
                String[] str = new String[roles.size()];
                for(int i=0;i<roles.size();i++){
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        //如果遍历完之后没有匹配上，说明该资源的访问不需要权限信息，设置一个登陆就能访问的角色
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
