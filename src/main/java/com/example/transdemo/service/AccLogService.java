package com.example.transdemo.service;

import com.example.transdemo.mapper.AccLogMapper;
import com.example.transdemo.pojo.AccLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccLogService {

    @Autowired
    AccLogMapper accLogMapper;

    public AccLog getLog(Integer id) {
        return accLogMapper.getLog(id);
    }

    @Transactional
    public void addLog(AccLog log) {
        accLogMapper.addLog(log);
    }
}
