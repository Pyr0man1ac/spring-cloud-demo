package org.pyro.alpha.service.feign;

import lombok.extern.slf4j.Slf4j;
import feign.hystrix.FallbackFactory;
// 不能是spring-cloud的FallbackFactory
// import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 12:11
 */
@Slf4j
@Component
public class PaymentFeignFallbackFactory implements FallbackFactory<PaymentFeign> {
    
    @Override
    public PaymentFeign create(Throwable cause) {
        log.warn("Use fallback caused by {}", cause.getMessage());
        log.debug("-------------------------------------------------------------------------");
        log.debug("Details: ", cause);
        log.debug("-------------------------------------------------------------------------");
        
        return new PaymentFeign() {
            
            @Override
            public Map<String, Object> selectPaymentById(Long id) {
                return createFakePayment();
            }
    
            @Override
            public Map<String, Object> insertPayment(Map<String, Object> payment) {
                return createFakePayment();
            }
            
        };
    }
    
    private Map<String, Object> createFakePayment() {
        Map<String, Object> payment = new HashMap<>(1);
        payment.put("description", "A fake payment...");
        return payment;
    }
    
}
