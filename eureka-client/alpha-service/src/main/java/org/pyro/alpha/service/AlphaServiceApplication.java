package org.pyro.alpha.service;

import org.pyro.alpha.service.mq.binding.CustomizeBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author MoronSlayer
 * @date 2021/4/23 9:32
 */
@EnableFeignClients
@EnableBinding(CustomizeBinding.class)
@SpringBootApplication
public class AlphaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaServiceApplication.class, args);
    }

}
