package com.infinidium.postgresql.admin.users.model.service;

import com.google.gson.JsonElement;
import com.infinidium.postgresql.admin.users.channel.service.TransactionServiceCallable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractTransactionService implements EntityService<JsonElement, Integer>
{
    @Autowired
    protected TransactionServiceCallable transactionServiceCallable;

    public abstract List<JsonElement> getAllTransactionsOfUser(Integer userID);
}
