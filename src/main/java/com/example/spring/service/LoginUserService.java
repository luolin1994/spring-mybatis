package com.example.spring.service;

import com.example.spring.bean.LoginUser;
import com.example.spring.mapper.LoginUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * SpringSecurity定义的核心接口，用于根据用户名获取用户信息，需要自行实现
 */
@Service
public class LoginUserService  implements UserDetailsService {

    @Autowired
    LoginUserMapper loginUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser loginUser = loginUserMapper.loadUserByUsername(username);
        if (loginUser == null){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        loginUser.setRoles(loginUserMapper.getLoginUserRolesById(loginUser.getId()));
        return loginUser;
    }
}
