package com.infinidium.postgresql.admin.users.model.service;

import com.google.gson.JsonElement;
import com.infinidium.postgresql.admin.users.channel.service.ProductServiceCallable;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractProductService implements EntityService<JsonElement, Integer>
{
    @Autowired
    protected ProductServiceCallable productServiceCallable;


}
