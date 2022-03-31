package bdb.test.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;

import bdb.test.test.pojos.Person;
import bdb.test.test.repositories.Person_repository;
import bdb.test.test.services.PersonService;

@SpringBootTest
class TestApplicationTests {

	@MockBean
	private Person_repository person_repository;

	@Autowired
	private PersonService personService;

	@Test
	public void findByIdTest(){
		Person p= new Person("0123456789", "person", LocalDate.parse("2002-01-10"));
		Mockito.when(person_repository.findById("0123456789")).thenReturn(Optional.ofNullable(p));

		Person found= personService.findById("0123456789");
		assertEquals(found, p);
	}

	@Test
	void saveTestToExistingUser(){
		Person p= new Person("0123456789", "person", LocalDate.parse("2002-01-10"));
		Mockito.when(person_repository.save(p)).thenReturn(null);

		Person found= personService.save(new Person("0123456789", "new", LocalDate.parse("2000-01-23")));

		assertEquals(found, null);
	}

	@Test
	void adoptTest(){
		Person p= new Person("0123456789", "person", LocalDate.parse("2002-01-10"));
		Person p1= new Person("1234567890", "person1", LocalDate.parse("2002-01-10"));
		Person p2= new Person("2345678901", "person2", LocalDate.parse("2002-01-10"));
		Person p3= new Person("3456789012", "person3", LocalDate.parse("2002-01-10"), p2, p1);
		//father
		Mockito.when(person_repository.findById(p.getId())).thenReturn(Optional.ofNullable(p));
		//Mother
		Mockito.when(person_repository.findById(p1.getId())).thenReturn(Optional.ofNullable(p1));
		//child
		Mockito.when(person_repository.findById(p2.getId())).thenReturn(Optional.ofNullable(p2));
		//another child
		Mockito.when(person_repository.findById(p3.getId())).thenReturn(Optional.ofNullable(p3));

		boolean wasAdopted= personService.adopt(p.getId(), p3.getId(), false);
		boolean wasAdopted2= personService.adopt(p.getId(), p2.getId(), false);
		assertFalse(wasAdopted);
		assertTrue(wasAdopted2);
	}

	@Test
	void contextLoads() {
		assertNotEquals(personService, null);;
	}

}
