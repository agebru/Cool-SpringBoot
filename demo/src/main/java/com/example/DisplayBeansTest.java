package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.domain.Person;
import com.example.service.IPersonService;

@SpringBootApplication
public class DisplayBeansTest {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {

		// ConfigurableApplicationContext applicationContext =
		// SpringApplication.run(DisplayBeansTest.class);

		// load all the beans and assign them into applicationContext
		applicationContext = SpringApplication.run(DisplayBeansTest.class);

		IPersonService pService = applicationContext.getBean("personService", IPersonService.class);
		if (pService != null) {
			List<Person> plist = pService.findAll();
			plist.stream().forEach(System.out::println);
		}

		/*
		 * String[] allBeans = applicationContext.getBeanDefinitionNames();
		 * 
		 * System.out.println("\n\n============ Displaying all the Beans =========");
		 * for (String beanName : allBeans) { System.out.println(beanName); }
		 */

		System.out.println("\n Displaying single Person:" + findPerson(1040));

	}

	public static Person findPerson(int id) {

		Person p = applicationContext.getBean("personService", IPersonService.class).findOne(id);
		return p != null ? p : null;

	}

}
