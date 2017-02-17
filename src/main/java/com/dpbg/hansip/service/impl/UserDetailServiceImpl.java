package com.dpbg.hansip.service.impl;

import com.dpbg.hansip.model.Role;
import com.dpbg.hansip.model.User;
import com.dpbg.hansip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zulfyadhie on 2/14/17.
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class, timeout = 30)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null || username.trim().isEmpty()){
            throw new IllegalArgumentException("Empty username");
        }

        User appUser = userRepository.findOneByUsername(username);
        if(appUser == null){
            throw new UsernameNotFoundException("User not found or inactive");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Role role : appUser.getRoleList()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getCode());
            grantedAuthorities.add(grantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(username, appUser.getPassword(), grantedAuthorities);
    }
}
