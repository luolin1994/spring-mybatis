package com.example.spring.mapper;


import com.example.spring.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {


    public User getUserById(Integer uid);

    public User findUserByUsername(String username);

    public void addUser(User user);

    public User findUserByCode(String code);

    public void updateUserStatus(User user);

    public User findUserByUsernameAndPassword(@Param("username") String username, @Param("username")String password);





}
