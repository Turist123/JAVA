package com.concretepage.service;

import com.concretepage.dao.IPersonDAO;
import com.concretepage.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private IPersonDAO personDAO;
	@Override
	public Person getPersonById(int pid) {
		Person obj = personDAO.getPersonById(pid);
		return obj;
	}	
	@Override
	public List<Person> getAllPersons(){
		return personDAO.getAllPersons();
	}
	@Override
	public synchronized boolean addPerson(Person person){
       if (personDAO.personExists(person.getUsername())) {
    	   return false;
       } else {
    	   personDAO.addPerson(person);
    	   return true;
       }
	}
	@Override
	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
	}
	@Override
	public void deletePerson(int pid) {
		personDAO.deletePerson(pid);
	}
}
