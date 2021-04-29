package org.pyro.beta.service.mq;

import lombok.extern.slf4j.Slf4j;
import org.pyro.beta.service.mq.binding.CustomizeBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;
import java.util.Objects;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/28 10:04
 */
@Slf4j
@EnableBinding(CustomizeBinding.class)
public class Consumer {
    
    @StreamListener(CustomizeBinding.PAYMENT_INPUT)
    public void handlePaymentInput(@Payload Map<String, Object> payload) {
        log.info("------------------------ PAYMENT INPUT START ------------------------");
        log.info(Objects.toString(payload));
        log.info("------------------------- PAYMENT INPUT END -------------------------");
    }
    
    @StreamListener(CustomizeBinding.ORDER_INPUT)
    public void handleOrderInput(@Payload Map<String, Object> payload) {
        log.info("------------------------- ORDER INPUT START -------------------------");
        log.info(Objects.toString(payload));
        log.info("-------------------------- ORDER INPUT END --------------------------");
    }
}
