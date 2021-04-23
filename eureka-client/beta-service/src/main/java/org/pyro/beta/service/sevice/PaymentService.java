package org.pyro.beta.service.sevice;

import lombok.extern.slf4j.Slf4j;
import org.pyro.core.util.ThreadUtil;
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
        ThreadUtil.wakeAfterMillis(1500);
        Payment payment = Payment.builder()
                .id(id)
                .price(BigDecimal.TEN)
                .description("That's a payment！")
                .build();
        log.info("Return {}", payment);
        return payment;
    }
    
    public Payment insertPayment(Payment payment) {
        payment.setId(97531L);
        payment.setCode(payment.getCode());
        payment.setPaymentNo(payment.getPaymentNo());
        payment.setDescription("A new payment");
        BigDecimal totalPrice = payment.getPrice().multiply(new BigDecimal(payment.getQuantity()));
        payment.setTotalPrice(totalPrice);
        log.info("Return {}", payment);
        return payment;
    }
    
}
