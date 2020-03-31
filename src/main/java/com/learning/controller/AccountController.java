package com.learning.controller;

import com.learning.entity.Account;
import com.learning.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tzwei
 * @create 2019/9/8
 * @since 1.0.0
 */
@RestController
@Slf4j
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccountById(id);
    }

    @RequestMapping(value = "/updateAccount/{id}",method = RequestMethod.GET)
    public String updateAccount(@PathVariable("id")int id){
        Account account = new Account();
        account.setMoney(8888d);
        account.setName("Xavier");
        account.setId(id);
        int t = accountService.update(account);
        if(t == 1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        int t = accountService.add(account);
        if(t == 1){
            return account.toString();
        }else {
            return "fail";
        }
    }
}
