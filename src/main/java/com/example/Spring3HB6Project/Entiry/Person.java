package com.example.Spring3HB6Project.Entiry;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.subst.Token.Type;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name="person")
@NoArgsConstructor
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	int personId;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column
	int age;
	
	@Column(name="is_active")
	String isActive;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	List<Phone> phones;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
