package com.example.service;

import java.util.List;
import com.example.domain.Person;

public interface IPersonService {
	public List<Person> findAll();
	public Person findOne(int personId);
	public void deletePerson(int personId);
	public void addPerson(Person person);

}
