package com.bread.zxc.auth.dao;

import com.bread.zxc.auth.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findAll();

    UserInfo findByUserId(Long userId);

}
