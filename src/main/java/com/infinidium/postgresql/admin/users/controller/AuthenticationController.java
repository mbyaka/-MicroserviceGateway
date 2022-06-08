package com.infinidium.postgresql.admin.users.controller;

import com.infinidium.postgresql.admin.users.model.entity.User;
import com.infinidium.postgresql.admin.users.model.service.AbstractAuthenticationService;
import com.infinidium.postgresql.admin.users.model.service.AbstractUserService;
import com.infinidium.postgresql.admin.users.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping("api/authentication")
@RestController
public class AuthenticationController
{
    @Autowired
    private AbstractAuthenticationService authenticationService;

    @Autowired
    private AbstractUserService userService;

    // OTURUM AC
    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user)
    {
        String signInJWT = authenticationService.signInAndReturnJWT(user);


        Util.createLogFile(getClass(), Level.INFO, user.getUsername()
                + " is signed in at " + Util.formatDate(new Date()));

        return new ResponseEntity<>(signInJWT, HttpStatus.OK);
    }

    // KAYDOL
    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user)
    {
        if(userService.findByUserName(user.getUsername()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
