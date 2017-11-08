package io.pivotal.workshop.simplerpcproducerrabbit

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

import java.text.SimpleDateFormat

@EnableScheduling
@SpringBootApplication
class SimpleRpcProducerRabbitApplication {

	private final RabbitTemplate rabbitTemplate

	static void main(String[] args) {
		SpringApplication.run SimpleRpcProducerRabbitApplication, args
	}

    @Autowired
    SimpleRpcProducerRabbitApplication(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate
    }

    @Scheduled(fixedRate = 1000)
    static void sendMessage() {
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date())
        String message = "Hello World! ${timestamp}"
    }

    @Bean
    Queue queue() {
        new Queue("spring-boot", false)
    }
}
