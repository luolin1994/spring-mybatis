package com.example.spring.mapper;


import com.example.spring.bean.LoginUser;
import com.example.spring.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginUserMapper {

    public LoginUser loadUserByUsername(String username);

    public List<Role> getLoginUserRolesById(Integer id);

}
