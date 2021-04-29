package org.pyro.beta.service;

import org.pyro.beta.service.mq.binding.CustomizeBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author MoronSlayer
 * @date 2021/4/23 20:39
 */
@EnableFeignClients
@EnableBinding(CustomizeBinding.class)
@SpringBootApplication
public class BetaServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BetaServiceApplication.class, args);
    }
    
}
