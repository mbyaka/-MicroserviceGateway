package com.infinidium.postgresql.admin.users.model.service;

import com.infinidium.postgresql.admin.users.model.entity.User;
import com.infinidium.postgresql.admin.users.utility.Util;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstractUserService
{
    @Override
    public Optional<User> findByUserName(String username)
    {
        return repository.findByUsername(username);
    }

    @Override
    public List<User> findAll()
    {
        return repository.findAll();
    }

    @Override
    public User save(User entity)
    {
        try
        {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            entity.setCreated(new Date());
            return repository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void deleteByID(Integer id)
    {
        try
        {
            repository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
        }
    }
}
