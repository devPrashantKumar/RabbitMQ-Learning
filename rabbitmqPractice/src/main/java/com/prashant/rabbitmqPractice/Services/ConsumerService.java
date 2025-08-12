package com.prashant.rabbitmqPractice.Services;

import com.prashant.rabbitmqPractice.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received: " + message);
        // Add processing logic here
    }
}
