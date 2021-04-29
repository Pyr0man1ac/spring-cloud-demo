package org.pyro.beta.service.mq.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/28 10:09
 */
public interface CustomizeBinding {
    
    String PAYMENT_INPUT = "paymentInput";
    
    String ORDER_INPUT = "orderInput";
    
    @Input(PAYMENT_INPUT)
    SubscribableChannel paymentInput();
    
    @Input(ORDER_INPUT)
    SubscribableChannel orderInput();
    
}
