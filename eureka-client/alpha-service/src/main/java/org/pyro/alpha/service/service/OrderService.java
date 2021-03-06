package org.pyro.alpha.service.service;

import lombok.extern.slf4j.Slf4j;
import org.pyro.alpha.service.feign.PaymentFeign;
import org.pyro.alpha.service.model.Order;
import org.pyro.alpha.service.mq.binding.CustomizeBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 10:07
 */
@Slf4j
@Service
@Transactional
public class OrderService {
    
    @Autowired
    private PaymentFeign paymentFeign;
    
    @Autowired
    @Qualifier(CustomizeBinding.ORDER_OUTPUT)
    private MessageChannel orderInput;
    
    public Order selectOrderById(Long id) {
        Order order = new Order();
        order.setId(id);
        order.setPrice(BigDecimal.TEN);
        order.setDescription("That's an order!");
    
        Map<String, Object> payment = paymentFeign.selectPaymentById(12321L);
        log.info("Payment Feign Return {}", payment);
        
        order.setPayment(payment);
        log.info("Return {}", order);
        return order;
    }
    
    public Order insertOrder(Order order) {
        order.setDescription(order.getDescription() + " And now I have a payment");
        
        Map<String, Object> param = new HashMap<>(1);
        param.put("code", order.getPayment().get("code"));
        param.put("paymentNo", order.getPayment().get("paymentNo"));
        param.put("price", order.getPrice());
        param.put("quantity", order.getQuantity());
        Map<String, Object> payment = paymentFeign.insertPayment(param);
        log.info("Payment Feign Return {}", payment);
        
        order.setPayment(payment);
        log.info("Return {}", order);
        return order;
    }
    
    public void async(Map<String, Object> params) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        params.put("sendDate", dateFormat.format(new Date()));
    
        orderInput.send(MessageBuilder.withPayload(params).build());
        log.info("Send Message {}", params);
    }
    
}
