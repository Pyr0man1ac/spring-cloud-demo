package org.pyro.beta.service.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 10:39
 */
@Data
@Builder
public class Payment {
    
    @Tolerate
    public Payment() {
        // Lombok @Builder注解会导致编译器不在生成无参构造器
    }
    
    private Long id;
    
    private String code;
    
    private Integer paymentNo;
    
    private BigDecimal price;
    
    private String description;
    
}
