package io.pivotal.workshop.simplerpcconsumerrabbit

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SimpleRpcConsumerRabbitApplication {

	static void main(String[] args) {
		SpringApplication.run SimpleRpcConsumerRabbitApplication, args
	}

	@RabbitListener(queues = "spring-boot")
    static void process(String message) {
        println ">>> ${message}"
    }

    @Bean
    Queue queue() {
        return new Queue("spring-boot", false)
    }
}
