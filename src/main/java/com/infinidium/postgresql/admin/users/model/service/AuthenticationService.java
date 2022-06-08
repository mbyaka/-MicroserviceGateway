package com.infinidium.postgresql.admin.users.model.service;

import com.infinidium.postgresql.admin.users.model.entity.User;
import com.infinidium.postgresql.admin.users.security.model.UserPrinciple;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService extends AbstractAuthenticationService
{
    @Override
    public String signInAndReturnJWT(User signInUser)
    {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(signInUser.getUsername(), signInUser.getPassword());

        Authentication authentication
                = authenticationManager.authenticate(token);

        // kimligi dogrulanmis kullanici cekilir
        UserPrinciple userPrinciple = (UserPrinciple)authentication.getPrincipal();

        // kimligi dogrulanmis kullaniciyi kullanarak token urettik
        return providable.generateToken(userPrinciple); // ***1
    }
}
