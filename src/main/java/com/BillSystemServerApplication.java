package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@MapperScan("com.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class BillSystemServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillSystemServerApplication.class, args);
    }

}
