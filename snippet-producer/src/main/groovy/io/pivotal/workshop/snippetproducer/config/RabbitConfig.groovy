package io.pivotal.workshop.snippetproducer.config

import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {

    private final ConnectionFactory connectionFactory

    RabbitConfig(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory
    }

    @Bean
    RabbitTemplate template() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(this.connectionFactory)
        rabbitTemplate.with {
            setRoutingKey 'spring-boot'
            setMessageConverter new Jackson2JsonMessageConverter()
        }
        rabbitTemplate
    }
}
