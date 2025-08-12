package com.prashant.rabbitmqPractice.Controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send/direct/{key}")
    public String sendDirect(@PathVariable String key, @RequestBody String message) {
        rabbitTemplate.convertAndSend("directExchange", key, message);
        System.out.println("Sent to Direct Exchange with key: " + key);
        return "Message sent";
    }

    @PostMapping("/send/fanout")
    public String sendFanout(@RequestBody String message) {
        rabbitTemplate.convertAndSend("fanoutExchange", "", message);
        System.out.println("Sent to Fanout Exchange");
        return "Fanout message sent";
    }

    @PostMapping("/send/topic/{key}")
    public String sendTopic(@PathVariable String key, @RequestBody String message) {
        rabbitTemplate.convertAndSend("topicExchange", key, message);
        System.out.println("Sent to Topic Exchange with key: "+ key);
        return "Topic message sent with key: " + key;
    }
}

