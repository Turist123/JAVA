package com.concretepage.dao;

import com.concretepage.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PersonDAO implements IPersonDAO {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	@Override
	public Person getPersonById(int pid) {
		return hibernateTemplate.get(Person.class, pid);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersons() {
		String hql = "FROM Person as p ORDER BY p.pid";
		return (List<Person>) hibernateTemplate.find(hql);
	}	
	@Override
	public void addPerson(Person person) {
		hibernateTemplate.save(person);
	}
	@Override
	public void updatePerson(Person person) {
		Person p = getPersonById(person.getPid());
		p.setUsername(person.getUsername());
		p.setPassword(person.getPassword());
		p.setAge(person.getAge());
		p.setGender(person.getGender());
		p.setCity(person.getCity());
		hibernateTemplate.update(p);
	}
	@Override
	public void deletePerson(int pid) {
		hibernateTemplate.delete(getPersonById(pid));
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean personExists(String username) {
		String hql = "FROM Person as p WHERE p.username = ?";
		List<Person> persons = (List<Person>) hibernateTemplate.find(hql, username);
		return persons.size() > 0 ? true : false;
	}
}
