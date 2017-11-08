package io.pivotal.directoryservice

import io.pivotal.directoryservice.repository.DirectoryRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DirectoryServiceApplication {

	static void main(String[] args) {
		SpringApplication.run DirectoryServiceApplication, args
	}

	@Bean
	CommandLineRunner addPersons(DirectoryRepository directoryRepository) {
        new DataLoader()
    }
}
