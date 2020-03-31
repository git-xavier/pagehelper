package com.learning.dao;

import com.learning.entity.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface AccountDaoMapper {

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select * from account where id = #{id}")
    Account findAccountById(int id);

    @Select("select * from account")
    List<Account> findAccountList();

    int update(Account account);

    int add(Account account);
}
