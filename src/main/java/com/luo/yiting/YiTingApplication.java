package com.luo.yiting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("com.luo.yiting.mapper")
public class YiTingApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiTingApplication.class, args);
    }

}
