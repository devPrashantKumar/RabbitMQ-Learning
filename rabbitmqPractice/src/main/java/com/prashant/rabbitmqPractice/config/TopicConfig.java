package com.prashant.rabbitmqPractice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Bean
    Queue topicQueue1() { return new Queue("topicQueue1", true); }

    @Bean
    Queue topicQueue2() { return new Queue("topicQueue2", true); }

    @Bean
    TopicExchange topicExchange() { return new TopicExchange("topicExchange"); }

    @Bean
    Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("sports.*");
    }

    @Bean
    Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("sports.#");
    }
}


