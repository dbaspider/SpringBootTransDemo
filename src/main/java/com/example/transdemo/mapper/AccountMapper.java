package com.example.transdemo.mapper;

import com.example.transdemo.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {

    @Select("select * from account where account_id = 1")
    Account getAccount();

    @Update("update account set balance = balance + 100 where account_id = 1")
    void addMoney();
}