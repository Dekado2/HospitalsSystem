package model;

import java.io.Serializable;
import java.util.Date;

public class Patient extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Patient(String id, String firstName, String surName, Date dateOfBirth, String city, String street,
			String gender, String phoneNumber, String bloodType, String careFacility, Person contactID) {
		super(id, firstName, surName, dateOfBirth, city, street, gender, phoneNumber, bloodType, careFacility, contactID);
	}
	public Patient(String id) {
		super(id);
	}

	

}
