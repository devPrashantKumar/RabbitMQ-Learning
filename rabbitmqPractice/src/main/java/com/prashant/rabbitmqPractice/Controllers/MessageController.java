package com.prashant.rabbitmqPractice.Controllers;

import com.prashant.rabbitmqPractice.Services.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final ProducerService producerService;

    public MessageController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody String message) {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent");
    }
}

