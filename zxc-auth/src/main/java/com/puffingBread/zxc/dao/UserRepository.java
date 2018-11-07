package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Victor on 2017/6/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    User save(User user);

    @Query("update User u set u.status = -2 where u.id = :id")
    void delete(Long id);

    User findByUsername(@Param("username") String username);
}
