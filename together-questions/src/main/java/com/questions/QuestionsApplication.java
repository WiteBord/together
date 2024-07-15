package com.questions;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages="com.questions.dao")
public class QuestionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionsApplication.class, args);
    }

}
