package org.pyro.alpha.service.mq;

import lombok.extern.slf4j.Slf4j;
import org.pyro.alpha.service.mq.binding.CustomizeBinding;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author ZYC MoronSlayer@outlook.com
 * @version 1.0
 * @date 2021/4/25 11:09
 */
@Slf4j
@EnableBinding(CustomizeBinding.class)
public class Consumer {
    
//    /**
//     *  这样写只是为了演示多种写法
//     *  实际上不应当使用这种方式 因为会造成重复消费
//     *  即使在同一个消费者组 因为这两个Handler属于同一个消费者实例
//     */
//    @StreamListener(CustomizeBinding.ORDER_INPUT)
//    public void consumeInputCopy(Message<Map<String, Object>> message) {
//        log.info("-------------------- MESSAGE START --------------------");
//        log.info(Objects.toString(message));
//        log.info(Objects.toString(message.getHeaders()));
//        log.info(Objects.toString(message.getPayload()));
//        log.info("--------------------- MESSAGE END ---------------------");
//    }
//
//    /**
//     *  这样写只是为了演示多种写法
//     *  实际上不应当使用这种方式 因为会造成重复消费
//     *  即使在同一个消费者组 因为这两个Handler属于同一个消费者实例
//     */
//    @StreamListener(CustomizeBinding.ORDER_INPUT)
//    public void consumeInput(@Headers MessageHeaders headers, @Payload Map<String, Object> payload) {
//        log.info("---------------- HEADERS PAYLOAD START ----------------");
//        log.info(Objects.toString(headers));
//        log.info(Objects.toString(payload));
//        log.info("----------------- HEADERS PAYLOAD END -----------------");
//    }
//
//    /**
//     *  这样写只是为了演示多种写法
//     *  实际上不应当使用这种方式 因为会造成重复消费
//     *  即使在同一个消费者组 因为这两个Handler属于同一个消费者实例
//     */
//    @StreamListener(CustomizeBinding.ORDER_INPUT)
//    public void consumeInput(@Header(name = "x-death", required = false) Map<String, Object> xDeath, @Headers MessageHeaders headers,  @Payload Map<String, Object> payload) {
//        log.info("------------- HEADER HEADERS PAYLOAD START -------------");
//        log.info(Objects.toString(xDeath));
//        log.info(Objects.toString(headers));
//        log.info(Objects.toString(payload));
//        log.info("-------------- HEADER HEADERS PAYLOAD END --------------");
////
////        if (Objects.nonNull(xDeath) && xDeath.get("count").equals(5L)) {
////            throw new AmqpRejectAndDontRequeueException("Reject And Dont Requeue");
////        }
////
////        throw new RuntimeException("THE EXCEPTION MESSAGE");
//    }
    
    /**
     * 注意
     * 如果 消息发布者的数据结构 与 消息订阅者的数据结构 不一致
     * 如 用String发布 用Map<String, Object>订阅
     * 会导致 消息Convert异常 实际并没有进入订阅方法执行相关逻辑
     * 如果 没有配置死信队列 && 没有配置重回队列
     * 会导致 超出重试次数后被视为消费成功 从队列中删除
     * 也就是说 会导致消息丢失
     */
    @StreamListener(CustomizeBinding.ORDER_INPUT)
    @SendTo(CustomizeBinding.PAYMENT_OUTPUT)
    public Map<String, Object> handleOrderInput(@Payload Map<String, Object> payload) {
        log.info("---------------- RECEIVE AND SEND START ----------------");
        log.info("RECEIVE FROM ORDER {}", payload);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        payload.put("receiveAndSendDate", dateFormat.format(new Date()));
        payload.put("newKey", "newValue");
        log.info("AND SEND TO PAYMENT {}", payload);
        log.info("----------------- RECEIVE AND SEND END -----------------");
        return payload;
    }
    
}
