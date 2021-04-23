package org.pyro.beta.service.controller;

import org.pyro.beta.service.model.Payment;
import org.pyro.beta.service.sevice.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 10:38
 */
@RestController
@RequestMapping("payment")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;
    
    @GetMapping("{paymentId}")
    public Payment selectPaymentById(@PathVariable("paymentId") Long id) {
        return paymentService.selectById(id);
    }
    
}
