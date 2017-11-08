package io.pivotal.directoryservice

import io.pivotal.directoryservice.domain.Directory
import io.pivotal.directoryservice.domain.Person
import io.pivotal.directoryservice.repository.DirectoryRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class DataLoader implements CommandLineRunner {

    private DirectoryRepository directoryRepository


    DataLoader(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository
    }

    @Override
    void run(String... args) throws Exception {
        List<Person> people = []
        people << new Person("John", "Doe", "john@email.com", "Denver, CO", "1")
        people << new Person("John", "Doe", "john@email.com", "Denver, CO", "1")
        people << new Person("John", "Doe", "john@email.com", "Denver, CO", "1")
        Directory directory = new Directory("my-directory", people)
        repo.save(directory)
    }
}
