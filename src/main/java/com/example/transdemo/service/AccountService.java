package com.example.transdemo.service;

import com.example.transdemo.mapper.AccountMapper;
import com.example.transdemo.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AccountService {

    //@SuppressWarnings("all")
    @Autowired
    AccountMapper accountMapper;

    public Account getAccount() {
        return accountMapper.getAccount();
    }

    @Transactional(rollbackFor = Exception.class)
    public void addMoney() throws Exception {
        //先增加余额
        accountMapper.addMoney();
        //然后遇到故障
        //throw new RuntimeException("发生异常了.."); -- ok --
        throw new SQLException("发生异常了.."); // -- not ok -- must add "rollbackFor"
    }

    @Transactional
    public void addMoney2() throws Exception {
        //先增加余额
        accountMapper.addMoney();
        //谨慎：尽量不要在业务层捕捉异常并处理
        try {
            throw new SQLException("发生异常了.."); // -- not ok --
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}