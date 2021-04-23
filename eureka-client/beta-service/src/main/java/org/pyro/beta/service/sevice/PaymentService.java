package org.pyro.beta.service.sevice;

import lombok.extern.slf4j.Slf4j;
import org.pyro.beta.service.model.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 10:44
 */
@Slf4j
@Service
@Transactional
public class PaymentService {
    
    public Payment selectById(Long id) {
        Payment payment = Payment.builder()
                .id(id)
                .price(BigDecimal.TEN)
                .description("That's a payment！")
                .build();
        log.info("Return {}", payment);
        return payment;
    }
    
}
