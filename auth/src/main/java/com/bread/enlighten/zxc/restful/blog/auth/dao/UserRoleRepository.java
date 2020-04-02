package com.bread.enlighten.zxc.restful.blog.auth.dao;

import com.bread.enlighten.zxc.restful.blog.auth.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Long userId);
}