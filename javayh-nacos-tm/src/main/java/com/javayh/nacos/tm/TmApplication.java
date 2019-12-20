package com.javayh.nacos.tm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description tm
 * @author Dylan
 * @date 2019/12/5
 */
@EnableTransactionManagerServer
@SpringBootApplication
public class TmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmApplication.class, args);
    }

}
