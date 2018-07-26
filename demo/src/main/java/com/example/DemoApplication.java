package com.example;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Person;
import com.example.service.IPersonService;

@RestController
@SpringBootApplication
public class DemoApplication {

	 @Autowired
	private IPersonService personService;
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);
		
		
		Properties prop=new Properties();
		prop.load(DemoApplication.class.getClassLoader().getResourceAsStream("hello.properties"));

		System.out.println(prop.getProperty("person.name"));
		System.out.println(prop.getProperty("person.age"));
		
		int pnrId=123;
		
		String pnrVal=String.valueOf(pnrId);
		System.out.println(String.valueOf(pnrId));
		
		System.out.println(pnrVal);
		
		
	}
	
	
	@GetMapping("/people")
	public List<Person> getPersons(){
		return personService.findAll();
	}
	
}
