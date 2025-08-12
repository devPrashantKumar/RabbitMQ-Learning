package com.prashant.rabbitmqPractice.Controllers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
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

    @PostMapping("send/header/{version}")
    public String sendHeaders(@RequestBody String message, @PathVariable int version) {
        MessageProperties props = new MessageProperties();
        props.setHeader("format", "pdf");
        props.setHeader("version", version);
        Message msg = new Message(message.getBytes(), props);
        System.out.println("Sent to Header Exchange");
        rabbitTemplate.send("headersExchange", "", msg);
        return "Headers message sent";
    }
}

