package com.example.spring.mapper;

import com.example.spring.bean.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    public List<Permission> getAllPermissionsWithRole();
}
