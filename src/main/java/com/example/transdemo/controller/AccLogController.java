package com.example.transdemo.controller;

import com.example.transdemo.pojo.AccLog;
import com.example.transdemo.service.AccLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccLogController {

    @Autowired
    AccLogService accLogService;

    @GetMapping("/log")
    public AccLog getLog() {
        //查询
        return accLogService.getLog(1);
    }

    @GetMapping("/log/add")
    public String addLog() {
        AccLog log = new AccLog();
        log.setAccountId("1");
        log.setAccountName("admin");
        log.setBalance(new BigDecimal(1000));

        try {
            accLogService.addLog(log);
        } catch (Exception e) {
            return "发生异常了：" + e.getMessage();
        }
        return "Add Log Success";
    }
}
