package org.pyro.beta.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author MoronSlayer
 * @date 2021/4/23 20:39
 */
@EnableFeignClients
@SpringBootApplication
public class BetaServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BetaServiceApplication.class, args);
    }
    
}
