package org.pyro.alpha.service.feign;

import org.pyro.core.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 11:09
 */
@FeignClient(value = "beta-service", configuration = FeignConfiguration.class, fallbackFactory = PaymentFeignFallbackFactory.class)
public interface PaymentFeign {
    
    @GetMapping("payment/{id}")
    Map<String, Object> selectPaymentById(@PathVariable Long id);
    
    @PostMapping("payment")
    Map<String, Object> insertPayment(@RequestBody Map<String, Object> payment);
    
}
