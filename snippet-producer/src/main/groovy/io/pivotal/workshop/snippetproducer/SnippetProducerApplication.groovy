package io.pivotal.workshop.snippetproducer

import io.pivotal.workshop.snippetproducer.domain.Snippet
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@SpringBootApplication
@EnableScheduling
class SnippetProducerApplication {

	private final RabbitTemplate rabbitTemplate

	static void main(String[] args) {
		SpringApplication.run SnippetProducerApplication, args
	}

	SnippetProducerApplication(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate
	}

	@Scheduled(fixedDelay = 1000)
	void sender() {
		Snippet snippet = new Snippet('JS: Alert', "alert('hi there');")
        this.rabbitTemplate.convertAndSend(Snippet)
	}
}
