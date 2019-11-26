package model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstName;
	private String surName;
	private Date dateOfBirth;
	private String city;
	private String street;
	private String gender;
	private String phoneNumber;
	private String bloodType;
	private String careFacility;
	private Person contact;
	
	public Person (String id, String firstName, String surName, Date dateOfBirth, String city, String street, String gender,
			String phoneNumber, String bloodType, String careFacility, Person contact)
	{
		this.id=id;
		this.firstName=firstName;
		this.surName=surName;
		this.dateOfBirth=dateOfBirth;
		this.city=city;
		this.street=street;
		this.gender=gender;
		this.phoneNumber=phoneNumber;
		this.bloodType=bloodType;
		this.careFacility=careFacility;
		this.contact=contact;
	}
	
	public Person (String id) {
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getCareFacility() {
		return careFacility;
	}

	public void setCareFacility(String careFacility) {
		this.careFacility = careFacility;
	}

	public Person getContact() {
		return contact;
	}

	public void setContact(Person contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", dateOfBirth=" + dateOfBirth
				+ ", city=" + city + ", street=" + street + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", bloodType=" + bloodType + ", careFacility=" + careFacility + ", contact=" + contact + "]";
	}

	
}
