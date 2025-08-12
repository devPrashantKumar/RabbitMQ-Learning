package com.prashant.rabbitmqPractice.Services;

import com.prashant.rabbitmqPractice.config.DirectConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = DirectConfig.QUEUE1)
    public void listenDirect1(String message) {
        System.out.println("Received in directQueue1: " + message);
    }

    @RabbitListener(queues = DirectConfig.QUEUE2)
    public void listenDirect2(String message) {
        System.out.println("Received in directQueue2: " + message);
    }

    @RabbitListener(queues = "fanoutQueue1")
    public void listenFanout1(String message) {
        System.out.println("Fanout Queue 1 received: " + message);
    }

    @RabbitListener(queues = "fanoutQueue2")
    public void listenFanout2(String message) {
        System.out.println("Fanout Queue 2 received: " + message);
    }

    @RabbitListener(queues = "topicQueue1")
    public void listenTopic1(String message) {
        System.out.println("Topic Queue 1 received: " + message);
    }

    @RabbitListener(queues = "topicQueue2")
    public void listenTopic2(String message) {
        System.out.println("Topic Queue 2 received: " + message);
    }
}
