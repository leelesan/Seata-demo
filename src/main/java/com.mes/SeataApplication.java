package com.mes;

import io.seata.spring.annotation.GlobalTransactionScanner;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoDataSourceProxy
public class SeataApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SeataApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 配置Seata分布式事务扫描器
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("my_group", "my_test_tx_group");
    }
}
