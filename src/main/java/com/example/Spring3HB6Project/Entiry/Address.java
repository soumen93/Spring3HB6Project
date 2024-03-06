package com.example.Spring3HB6Project.Entiry;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	@Column(name="houseNo")
	String houseNo;
	
	@Column
	String city;
	
	@Column
	String state;
	
	@Column
	String country;
	
	@Column
	String pinCode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="personId")
	Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
