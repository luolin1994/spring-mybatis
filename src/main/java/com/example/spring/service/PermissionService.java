package com.example.spring.service;

import com.example.spring.bean.Permission;
import com.example.spring.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    public List<Permission> getAllPermissionsWithRole(){
        return permissionMapper.getAllPermissionsWithRole();
    }

}
