package com.example.transdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TransDemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(TransDemoApplication.class, args);

        //1.初始化
        SpringApplication application=  new SpringApplication(TransDemoApplication.class);

        //2.添加数据源
        //Map<String,Object> map = new HashMap<>();
        //map.put("spring.datasource.url", "jdbc:mysql://localhost:3306/socks?useSSL=false");
        //map.put("spring.datasource.username", "root");
        //map.put("spring.datasource.password", "123456");

        //3.开启驼峰映射 (Such as account_id ==> accountId)
        //map.put("mybatis.configuration.map-underscore-to-camel-case", true);
        //application.setDefaultProperties(map);

        //4.启动应用
        application.run(args);
    }

}
