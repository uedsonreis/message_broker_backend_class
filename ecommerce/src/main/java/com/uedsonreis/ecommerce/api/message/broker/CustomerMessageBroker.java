package com.uedsonreis.ecommerce.api.message.broker;

import com.uedsonreis.ecommerce.api.dto.MessageBroker;
import com.uedsonreis.ecommerce.service.CustomerService;
import com.uedsonreis.ecommerce.util.JsonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMessageBroker {

    @Autowired
    private CustomerService service;

    @RabbitListener(queues = "customer_queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        try {
            MessageBroker messageBroker = JsonUtil.toObject(message, MessageBroker.class);

            if ("customer.save".equals(messageBroker.getPattern())) {
                this.service.save(messageBroker.getData());

            } else if ("customer.delete".equals(messageBroker.getPattern())) {
                this.service.delete(messageBroker.getData());
            }
            System.out.println("Customer updated successfully");

        } catch (Exception e) {
            System.err.println("Error on update Customer: ");
            e.printStackTrace();
        }
    }

}
