package org.pyro.alpha.service.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/23 10:13
 */
@Data
@Builder
public class Order {
    
    @Tolerate
    public Order() {
        // Lombok @Builder注解会导致编译器不在生成无参构造器
    }
    
    private Long id;
    
    private String code;
    
    private Integer orderNo;
    
    private BigDecimal price;
    
    private String description;
    
}
