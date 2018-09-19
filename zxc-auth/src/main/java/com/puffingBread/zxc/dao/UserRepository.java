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

    @Query("select u from User u where u.status > -1 and u.userId = :id ")
    User findById(Long id);

    @Query("select u from User u where u.status > -1")
    List<User> getAll();

    User save(User user);

    @Query("update User u set u.status = -2 where u.userId = :id")
    void delete(Long id);

    User findByUserName(@Param("username") String username);
}
