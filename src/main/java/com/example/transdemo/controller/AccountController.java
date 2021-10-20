package com.example.transdemo.controller;

import com.example.transdemo.pojo.AccLog;
import com.example.transdemo.pojo.Account;
import com.example.transdemo.service.AccLogService;
import com.example.transdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    //@SuppressWarnings("all")
    @Autowired
    AccountService accountService;

    @Autowired
    AccLogService accLogService;

    @GetMapping("/")
    public Account getAccount() {
        //查询账户
        return accountService.getAccount();
    }

    @GetMapping("/add")
    public Object addMoney() {
        try {
            // 1. log -- not work --
            Account acc = accountService.getAccount();
            AccLog log = new AccLog();
            log.setBalance(acc.getBalance());
            log.setAccountName(acc.getAccountName());
            log.setAccountId(acc.getAccountId());
            accLogService.addLog(log);
            // 2. add
            accountService.addMoney();
        } catch (Exception e) {
            return "发生异常了：" + accountService.getAccount();
        }
        return getAccount();
    }
}