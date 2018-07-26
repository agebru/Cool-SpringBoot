package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IPersonDao;
import com.example.domain.Person;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private IPersonDao personDao;
	
	@Override
	public List<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	public Person findOne(int personId) {
		return personDao.findOne(personId);
	}

	@Override
	public void deletePerson(int personId) {
		personDao.deletePerson(personId);

	}

	@Override
	public void addPerson(Person person) {
		personDao.addPerson(person);

	}

}
