package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Date dateOfGraduation;
    private boolean manager;
    private Hospital hospital;
    private Department department;
    private ArrayList<Date> vacations;
    
	public Doctor(String id, String firstName, String surName, Date dateOfBirth, String city, String street,
			String gender, String phoneNumber, String bloodType, String careFacility, Person contact, Date dateOfGraduation,
			boolean manager, Hospital hospital, Department department) {
		super(id, firstName, surName, dateOfBirth, city, street, gender, phoneNumber, bloodType, careFacility, contact);
		this.dateOfGraduation=dateOfGraduation;
		this.manager=manager;
		this.hospital=hospital;
		this.department=department;
		this.vacations=new ArrayList<Date>();
	}
	
	public Doctor(String id) {
		super(id);

		this.vacations=new ArrayList<Date>();
	}


	public Date getDateOfGraduation() {
		return dateOfGraduation;
	}

	public void setDateOfGraduation(Date dateOfGraduation) {
		this.dateOfGraduation = dateOfGraduation;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ArrayList<Date> getVacations() {
		return vacations;
	}

	public void setVacations(ArrayList<Date> vacations) {
		this.vacations = vacations;
	}

	@Override
	public String toString() {
			return "Person [id=" + super.getId() + ", firstName=" + super.getFirstName() + ", surName=" + super.getSurName() + ", dateOfBirth=" + super.getDateOfBirth()
					+ ", city=" + super.getCity() + ", street=" + super.getStreet() + ", gender=" + super.getGender() + ", phoneNumber=" + super.getPhoneNumber()
					+ ", bloodType=" + super.getBloodType() + ", careFacility=" + super.getCareFacility() + ", contact=" + super.getContact()  + " dateOfGraduation=" + dateOfGraduation + ", manager=" + manager + ", hospital=" + hospital
					+ ", department=" + department +  ", vacations=" + vacations + "]";
	}
	
}
