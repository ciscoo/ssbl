package io.pivotal.directoryservice.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person {

    @Id
    @GeneratedValue
    private Long id
    private String firstName
    private String lastName
    private String email
    private String address
    private String phone

    Person(String firstName, String lastName, String email, String address, String phone) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.address = address
        this.phone = phone
    }
}
