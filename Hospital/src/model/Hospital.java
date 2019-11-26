package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Hospital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hospitalID;
	private String name;
	private String city;
	private String street;
	private String phone;
	private ArrayList<Department> departments;
	
	public Hospital (String hospitalID, String name, String city, String street, String phone)
	{
		this.hospitalID=hospitalID;
		this.name=name;
		this.city=city;
		this.street=street;
		this.phone=phone;
		this.departments=new ArrayList<Department>();
	}
	public Hospital (String hospitalID) {
		this.hospitalID=hospitalID;
		this.departments=new ArrayList<Department>();
	}
	
	public Hospital (String hospitalID, String name) {
		this.hospitalID=hospitalID;
		this.name=name;
		this.departments=new ArrayList<Department>();
	}

	public String getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospitalID == null) ? 0 : hospitalID.hashCode());
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
		Hospital other = (Hospital) obj;
		if (hospitalID == null) {
			if (other.hospitalID != null)
				return false;
		} else if (!hospitalID.equals(other.hospitalID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalID=" + hospitalID + ", name=" + name + ", city=" + city + ", street=" + street
				+ ", phone=" + phone + ", departments=" + departments + "]";
	}

	
}
