package com.learning.service.impl;

import com.learning.service.IAccountService;
import com.learning.dao.AccountDaoMapper;
import com.learning.entity.Account;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzwei
 * @create 2019/9/8
 * @since 1.0.0
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private AccountDaoMapper accountDaoMapper;

    @Override
    public int add(Account account) {
        return accountDaoMapper.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDaoMapper.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDaoMapper.delete(id);
    }

    @Cacheable("amount")
    @Override
    public Account findAccountById(int id) {
        simulateSlowService();
        return accountDaoMapper.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDaoMapper.findAccountList();
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
