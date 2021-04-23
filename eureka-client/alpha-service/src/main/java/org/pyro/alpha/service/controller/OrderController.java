package org.pyro.alpha.service.controller;

import org.pyro.alpha.service.model.Order;
import org.pyro.alpha.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 9:43
 */
@RestController
@RequestMapping("order")
public class OrderController {
    
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("{orderId}")
    public Order selectOrderById(@PathVariable("orderId") Long id) {
        return orderService.selectOrderById(id);
    }
}
