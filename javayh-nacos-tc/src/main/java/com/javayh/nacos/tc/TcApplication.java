package com.javayh.nacos.tc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableDistributedTransaction
@EnableFeignClients
@SpringBootApplication
public class TcApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcApplication.class, args);
    }

}
