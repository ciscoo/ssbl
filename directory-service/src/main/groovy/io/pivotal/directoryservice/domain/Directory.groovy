package io.pivotal.directoryservice.domain

import javax.persistence.*

@Entity
class Directory {

    @Id
    @GeneratedValue
    private Long id
    private String name

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Person> people

    Directory(String name) {
        this.name = name
    }

    Directory(String name, List<Person> people) {
        this.name = name
        this.people = people
    }
}
