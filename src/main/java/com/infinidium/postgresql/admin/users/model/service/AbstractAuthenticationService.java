package com.infinidium.postgresql.admin.users.model.service;

import com.infinidium.postgresql.admin.users.model.entity.User;
import com.infinidium.postgresql.admin.users.security.jwt.JWTProvidable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

public abstract class AbstractAuthenticationService
{
    @Autowired
    protected JWTProvidable providable;

    @Autowired
    protected AuthenticationManager authenticationManager;

    public abstract String signInAndReturnJWT(User signInUser);
}
