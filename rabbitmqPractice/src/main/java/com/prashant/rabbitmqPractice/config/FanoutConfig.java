package com.prashant.rabbitmqPractice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    Queue fanoutQueue1() { return new Queue("fanoutQueue1", true); }

    @Bean
    Queue fanoutQueue2() { return new Queue("fanoutQueue2", true); }

    @Bean
    FanoutExchange fanoutExchange() { return new FanoutExchange("fanoutExchange"); }

    @Bean
    Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
}

