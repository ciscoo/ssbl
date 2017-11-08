package io.pivotal.directoryservice.repository

import io.pivotal.directoryservice.domain.Directory
import org.springframework.data.repository.CrudRepository

class DirectoryRepository extends CrudRepository<Directory, Long> {
}
