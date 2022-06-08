package com.infinidium.postgresql.admin.users.model.service;

import com.google.gson.JsonElement;
import com.infinidium.postgresql.admin.users.channel.utility.RetrofitUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class ProductService extends AbstractProductService
{
    private Response<Void> response;

    @Override
    public List<JsonElement> findAll()
    {
        return RetrofitUtil.callGenericBlock(productServiceCallable.getAll());
    }

    @Override
    public JsonElement save(JsonElement entity)
    {
        return RetrofitUtil.callGenericBlock(productServiceCallable.save(entity));
    }

    @Override
    public void deleteByID(Integer id)
    {
        RetrofitUtil.callGenericBlock(productServiceCallable.deleteByID(id));
    }
}
