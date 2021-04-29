package org.pyro.alpha.service.mq.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/26 15:59
 */
public interface CustomizeBinding {
    
    /**
     *  常量方便设置@StreamListener监听Topic 所以Inbound可以设置 而Outbound可以不设置（但不推荐这么做）
     *  注解@Input和@Output缺省值为对应接口名称
     *  注解@Input和@Output的值对应了YAML文件中spring.cloud.stream.bindings下的<channelName>
     *  可设置spring.cloud.stream.bindings.<channelName>.destination 为自动创建的Topic名称
     *  spring.cloud.stream.bindings.<channelName>.destination缺省值为<channelName>
     */
    
    String ORDER_INPUT = "orderInput";
    
    String ORDER_OUTPUT = "orderOutput";
    
    String PAYMENT_OUTPUT = "paymentOutput";
    
    @Input(ORDER_INPUT)
    SubscribableChannel orderInput();
    
    @Output(ORDER_OUTPUT)
    MessageChannel orderOutput();
    
    @Output(PAYMENT_OUTPUT)
    MessageChannel paymentOutput();
    
}
