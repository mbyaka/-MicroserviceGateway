package com.infinidium.postgresql.admin.users.channel.utility;

import com.google.gson.JsonElement;
import com.infinidium.postgresql.admin.users.utility.Util;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
public final class RetrofitUtil
{
    private RetrofitUtil() {}

    public static <T> T callGenericBlock(Call<T> request)
    {
        try
        {
            Response<T> response = request.execute();

            if(!response.isSuccessful())
            {
                log.error("Unsuccessfull request. Error reason:", response.errorBody().string());
            }

            return response.body();
        }
        catch (IOException e)
        {
            Util.showExceptionInfo(e);
            return null;
        }
    }
}
