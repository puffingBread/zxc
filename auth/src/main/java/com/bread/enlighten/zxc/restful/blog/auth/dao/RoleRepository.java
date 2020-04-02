package com.bread.enlighten.zxc.restful.blog.auth.dao;

import com.bread.enlighten.zxc.restful.blog.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByIdIn(List<Long> ids);

}
