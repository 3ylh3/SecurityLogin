package com.xiaobai.securitylogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaobai.securitylogin.dao")
public class SecurityloginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityloginApplication.class, args);
    }

}
