package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.dao.RoleRepository;
import com.puffingBread.zxc.dao.UserRepository;
import com.puffingBread.zxc.model.Role;
import com.puffingBread.zxc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 12.11.2016.
 */
@Service(value = "UserDetailsServiceImpl")
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public AuthUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(username);

        if (user == null){
            throw new UsernameNotFoundException("user not found");
        }

//        List<Role> roleList = roleRepository.findByUserId(user.getUserId());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();

//        for (Role role : roleList) {
//            authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
//        }
        return new AuthUserDetails(user.getUserId(), user.getUserName(), user.getPassword(), String.valueOf(user.getStatus()), authorityList);
    }
}
