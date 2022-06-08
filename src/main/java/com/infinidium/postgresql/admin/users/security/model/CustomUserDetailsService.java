package com.infinidium.postgresql.admin.users.security.model;

import com.infinidium.postgresql.admin.users.model.entity.User;
import com.infinidium.postgresql.admin.users.model.service.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private AbstractUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findByUserName(username)
                   .orElseThrow(() -> new UsernameNotFoundException("User with " + username + " not found"));

        return new UserPrinciple(user.getUserID(), user.getUsername(), user.getPassword());
    }
}
