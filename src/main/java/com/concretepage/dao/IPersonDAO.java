package com.concretepage.dao;

import com.concretepage.entity.Person;

import java.util.List;

public interface IPersonDAO {
    List<Person> getAllPersons();
    Person getPersonById(int pid);
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int pid);
    boolean personExists(String username);
}
 