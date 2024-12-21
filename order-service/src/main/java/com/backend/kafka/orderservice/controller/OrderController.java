package com.backend.kafka.orderservice.controller;

import com.backend.kafka.basedomains.dto.Order;
import com.backend.kafka.basedomains.dto.OrderEvent;
import com.backend.kafka.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping(value = "/orders")
    public String placeOrder(@RequestBody Order order){

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setStatus("Order is in Pending State");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return "Order Placed Successfully";
    }
}
