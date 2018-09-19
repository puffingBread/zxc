package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findById(@Param("id") long id);

}
