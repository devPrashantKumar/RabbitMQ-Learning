package com.prashant.rabbitmqPractice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    public static final String DIRECT_EXCHANGE = "directExchange";
    public static final String QUEUE1 = "directQueue1";
    public static final String QUEUE2 = "directQueue2";
    public static final String ROUTING_KEY1 = "practice.key1";
    public static final String ROUTING_KEY2 = "practice.key2";

    @Bean
    Queue directQueue1() { return new Queue(QUEUE1, true); }

    @Bean
    Queue directQueue2() { return new Queue(QUEUE2, true); }

    @Bean
    DirectExchange directExchange() { return new DirectExchange(DIRECT_EXCHANGE); }

    @Bean
    Binding bindingDirect1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(ROUTING_KEY1);
    }

    @Bean
    Binding bindingDirect2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(ROUTING_KEY2);
    }
}

