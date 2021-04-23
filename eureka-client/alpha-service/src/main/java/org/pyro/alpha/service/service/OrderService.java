package org.pyro.alpha.service.service;

import lombok.extern.slf4j.Slf4j;
import org.pyro.alpha.service.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 10:07
 */
@Slf4j
@Service
@Transactional
public class OrderService {
    
    public Order selectOrderById(Long id) {
        Order order = new Order();
        order.setId(id);
        order.setPrice(BigDecimal.TEN);
        order.setDescription("That's an order!");
        log.info("Return {}", order);
        return order;
    }
    
}
