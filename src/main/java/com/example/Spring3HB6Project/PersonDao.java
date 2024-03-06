package com.example.Spring3HB6Project;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Spring3HB6Project.Entiry.CustomResponseObject;
import com.example.Spring3HB6Project.Entiry.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class PersonDao implements PersonDaoInterface  {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public List<Person> getPerson() {
		 String HQL ="from Person";
		 TypedQuery<Person> query = entityManager.createQuery(HQL, Person.class);
		 List<Person> result=query.getResultList();
		 System.out.println(result);
		 return result;
	}
	
	@Transactional
	public List<?> getSelectedJoinFields() {
		 String HQL ="select p.firstName, p.lastName,phone.phoneNumber from Person p inner join p.phones phone";
		 TypedQuery<List> query = entityManager.createQuery(HQL, List.class);
		 List result=query.getResultList();
		 System.out.println(result);
		 return result;
	}
	
	
	
	@Transactional
	public List<Person> getSelectedJoinFieldsUsingCriteria() {
		
		 CriteriaQuery<Person> cr =entityManager.getCriteriaBuilder().createQuery(Person.class);
		 Root<Person> root=cr.from(Person.class);
		 cr.select(root);
		 
		 TypedQuery<Person> result=entityManager.createQuery(cr);
		 List<Person> personList=result.getResultList();
		
		 return personList;
	}
	
	@Transactional
	public List getJoinQueryResult(){
		try{
			String HQL = "from Person p inner join fetch p.phones";
			TypedQuery<Person> query= entityManager.createQuery(HQL, Person.class);
			List result=query.getResultList();
			
			return result;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Transactional
	public List getJoinQueryResultByNativeQuery(){
		try{
			String nativeQuery = "select p.*,phone.* from person p,phone phone where person.person_id=phone.person_id";
			Query query= entityManager.createNativeQuery(nativeQuery);
			List result=query.getResultList();
			
			return result;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Transactional
	public List<CustomResponseObject> getMultipleJoinQueryResultByNativeQuery(){
		try{
			
			String nativeQuery = "select p.first_name as firstName, p.last_name as lastName, phone.phone_number as phoneNumber,"
					+ "phone.operator as operator,address.city from person p inner join phone phone on p.person_id=phone.person_id\r\n"
					+ "inner join address on p.person_id=address.person_id";
			
			
			Query query= entityManager.createNativeQuery(nativeQuery);
			List<CustomResponseObject> result=query.getResultList();
			
			return result;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Transactional
	public void savePerson(Person person) {
		
		try{
			entityManager.persist(person);;
			
		}catch(Exception e) {
		}
		
	}

}
