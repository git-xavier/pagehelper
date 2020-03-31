package com.learning.service;

import com.learning.entity.Account;

import java.util.List;

public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int  delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
