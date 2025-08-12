package com.prashant.rabbitmqPractice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class HeaderConfig {

    @Bean
    Queue headersQueue1() { return new Queue("headersQueue1", true); }

    @Bean
    Queue headersQueue2() { return new Queue("headersQueue2", true); }


    @Bean
    HeadersExchange headersExchange() { return new HeadersExchange("headersExchange"); }

    @Bean
    Binding headersBinding1() {
        return BindingBuilder.bind(headersQueue1())
                .to(headersExchange())
                .whereAll(Map.of("format", "pdf", "version", 1)).match();
    }

    @Bean
    Binding headersBinding2() {
        return BindingBuilder.bind(headersQueue2())
                .to(headersExchange())
                .whereAll(Map.of("format", "pdf", "version", 2)).match();
    }
}

