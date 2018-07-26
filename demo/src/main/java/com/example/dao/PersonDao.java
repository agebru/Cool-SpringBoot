package com.example.dao;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.Person;
import com.sun.org.apache.xml.internal.serialize.OutputFormat.DTD;

@Repository
public class PersonDao implements IPersonDao {
	private static List<Person> persons;
	private static DateTimeFormatter formater = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	static {

		persons = new ArrayList<Person>();
		Person jack = new Person(1201, "Jack", "Peter", LocalDate.of(2011, Month.FEBRUARY, 10));// 02/10/2011
		Person emanuel = new Person(1214, "Emmanuel", "Gebru", LocalDate.of(1990, Month.APRIL, 21));// 04/21/1990
		Person hagos = new Person(1030, "Hagos", "Belay", LocalDate.of(1982, Month.MAY, 16));
		Person melat = new Person(1040, "Melat", "Mikre", LocalDate.of(1992, Month.DECEMBER, 21));

		persons.add(melat);
		persons.add(emanuel);
		persons.add(hagos);
		persons.add(jack);

	}

	@Override
	public List<Person> findAll() {
		return persons;
	}

	@Override
	public Person findOne(int personId) {
		return persons.stream().filter(person -> person.getId() == personId).map(tempPerson -> {

			if (tempPerson.getId() == 1040) {//only Concat LastName for Melat  whose ID:1040
				tempPerson.setLastName(tempPerson.getLastName().concat(" Asgedom"));
			}
			tempPerson.getDob().format(formater);
			return tempPerson;
		}

		).findFirst().get();
	}
	
	

	@Override
	public void deletePerson(int personId) {
		persons.removeIf(person -> person.getId() == personId);

	}

	@Override
	public void addPerson(Person person) {
		persons.add(person);

	}

}
