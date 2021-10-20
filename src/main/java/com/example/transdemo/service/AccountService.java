package com.example.transdemo.service;

import com.example.transdemo.mapper.AccountMapper;
import com.example.transdemo.pojo.AccLog;
import com.example.transdemo.pojo.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    //@SuppressWarnings("all")
    @Autowired
    AccountMapper accountMapper;

    @Autowired
    AccLogService accLogService;

    public Account getAccount() {
        return accountMapper.getAccount();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addMoney() throws Exception {
        logger.info("addMoney -- log");
        // first log
//        Account acc = accountMapper.getAccount();
//        AccLog log = new AccLog();
//        log.setBalance(acc.getBalance());
//        log.setAccountName(acc.getAccountName());
//        log.setAccountId(acc.getAccountId());
//        accLogService.addLog(log);

        logger.info("addMoney -- add");
        //先增加余额
        accountMapper.addMoney();

        logger.info("addMoney -- error occur");
        //然后遇到故障
        //throw new RuntimeException("发生异常了.."); -- ok --
        throw new SQLException("发生异常了.."); // -- not ok -- must add "rollbackFor"
    }

    @Transactional(propagation = Propagation.REQUIRED)
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