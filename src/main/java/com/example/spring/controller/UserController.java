package com.example.spring.controller;

import com.example.spring.bean.User;
import com.example.spring.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户管理相关接口")
public class UserController {


    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    @ApiOperation("查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "5")
    public User getUser(@PathVariable("id") Integer id){

        return userMapper.getUserById(id);


    }

    @GetMapping("/find/{username}")
    public User getUserByName(@PathVariable("username") String username)
    {
        return userMapper.findUserByUsername(username);
    }


}
