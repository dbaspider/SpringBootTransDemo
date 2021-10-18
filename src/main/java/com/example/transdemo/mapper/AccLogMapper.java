package com.example.transdemo.mapper;

import com.example.transdemo.pojo.AccLog;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccLogMapper {

    @Select("select * from account_log where log_id = #{id}")
    AccLog getLog(Integer id);

    @Insert("insert into account_log (log_id, account_id, account_name, balance) values (null, #{accountId}, #{accountName}, #{balance})")
    void addLog(AccLog log);
}
