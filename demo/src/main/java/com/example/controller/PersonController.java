package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Person;
import com.example.service.IPersonService;

@RestController
public class PersonController {

	@Autowired
	private IPersonService personService;

	@GetMapping("/persons")
	public List<Person> findPersons() {
		return personService.findAll();
	}

	@GetMapping("/persons/{personId}")
	public Person findPerson(@PathVariable("personId") int personId) {
		return personService.findOne(personId);
	}

	@DeleteMapping("persons/delete/{personId}")
	public List<Person> deletePerson(@PathVariable("personId") int personId) {
		personService.deletePerson(personId);
		return findPersons();

	}
	
	@PostMapping("persons/add")
	public List<Person> AddPerson(@RequestBody Person person) {
		personService.addPerson(person);
		return findPersons();

	}
	
	
	

}
