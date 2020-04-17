package com.example.spring.mapper;

import com.example.spring.bean.Permission;

import java.util.List;

public interface PermissionMapper {

    public List<Permission> getAllPermissionsWithRole();
}
