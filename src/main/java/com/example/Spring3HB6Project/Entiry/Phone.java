package com.example.Spring3HB6Project.Entiry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name="phone")
@NoArgsConstructor
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	@Column(name="phone_number")
	String phoneNumber;
	
	@Column(name="operator")
	String operator;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	Person person;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
