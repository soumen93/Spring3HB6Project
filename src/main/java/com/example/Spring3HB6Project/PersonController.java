package com.example.Spring3HB6Project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring3HB6Project.Entiry.Address;
import com.example.Spring3HB6Project.Entiry.CustomResponseObject;
import com.example.Spring3HB6Project.Entiry.Person;
import com.example.Spring3HB6Project.Entiry.Phone;

@RestController
public class PersonController {
	@Autowired
	PersonDao personDao;
	
	@GetMapping("/getPersonByCriteriaQuery")
	public ResponseEntity<List<Person>> getPersonByCriteriaQuery(){
		List<Person> personList=personDao.getSelectedJoinFieldsUsingCriteria();
		
		return new ResponseEntity<List<Person>>(personList, HttpStatus.OK); 
	}
	
	@GetMapping("/personList")
	public ResponseEntity<List<Person>> getAllPerson(){
		List<Person> personList=personDao.getJoinQueryResultByNativeQuery();
		
		return new ResponseEntity<List<Person>>(personList, HttpStatus.OK); 
	}
	
	@GetMapping("/getPersonPhone")
	public ResponseEntity<?> getPersonPhone(){
		List personList=personDao.getJoinQueryResult();
		
		return new ResponseEntity<>(personList,HttpStatus.OK); 
	}
	
	@GetMapping("/getSelectedJoinFields")
	public ResponseEntity<CustomResponseObject> getSelectedJoinFields(){
		List<CustomResponseObject> fieldList=personDao.getMultipleJoinQueryResultByNativeQuery();
		
		return new ResponseEntity(fieldList,HttpStatus.OK); 
	}
	
	
	@PostMapping("/createPerson")
	public ResponseEntity<Person> createPerson(){
		Person person=new Person();
		person.setFirstName("Narahari");
		person.setLastName("G");
		person.setAge(30);
		person.setIsActive("yes");
		
		List<Phone> phones = new ArrayList<Phone>();
		
		Phone phone1 = new Phone();
		phone1.setPhoneNumber("12345");
		phone1.setOperator("Idea");
		phone1.setPerson(person);
		
		Phone phone2 = new Phone();
		phone2.setPhoneNumber("567890");
		phone2.setOperator("Jio");
		phone2.setPerson(person);
		
		phones.add(phone1);
		phones.add(phone2);
		
		person.setPhones(phones);
		
		Address address= new Address();
		address.setCity("Kolkata");
		address.setCountry("India");
		address.setPinCode("700135");
		address.setState("WB");
		address.setPerson(person);
		
		person.setAddress(address);
		
		personDao.savePerson(person);
		
		return new ResponseEntity<Person>(HttpStatus.OK);
	}

}
