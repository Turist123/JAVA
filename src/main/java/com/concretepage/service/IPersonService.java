package com.concretepage.service;

import com.concretepage.entity.Person;

import java.util.List;

public interface IPersonService {
     List<Person> getAllPersons();
     Person getPersonById(int pid);
     boolean addPerson(Person person);
     void updatePerson(Person person);
     void deletePerson(int pid);
}
