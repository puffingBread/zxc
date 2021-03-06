package com.humor.zxc.service.impl;

import com.humor.zxc.dao.RoleRepository;
import com.humor.zxc.dao.UserRepository;
import com.humor.zxc.dao.UserRoleRepository;
import com.humor.zxc.model.Role;
import com.humor.zxc.model.User;
import com.humor.zxc.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private UserRoleRepository userRoleRepository;

    public AuthUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        List<UserRole> userRoleList = userRoleRepository.findByUserId(user.getId());

        List<Long> roleIds = userRoleList
                .stream()
                .map(UserRole::getRoleId)
                .collect(Collectors.toList());

        List<Role> roleList = roleRepository.findByIdIn(roleIds);
        for (Role role : roleList) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }

        return new AuthUserDetails(user.getId(), user.getUsername(), user.getPassword(), user.getStatus(), authorityList);
    }
}
