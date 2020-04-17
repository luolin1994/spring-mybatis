package com.example.spring;

import com.example.spring.bean.User;
import com.example.spring.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {

        //日志的级别;
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别;日志就只会在这个级别以以后的高级别生效
//        logger.trace("这是trace信息");
//        logger.debug("这是debug信息");
//        //SpringBoot默认给我们使用的是info级别的,没有指定级别的就用SpringBoot默认规定的级别;root级别
//        logger.info("这是info信息");
//        logger.warn("这是warn信息");
//        logger.error("这是error日志...");

        System.out.println(new BCryptPasswordEncoder().encode("123456"));



    }




}
