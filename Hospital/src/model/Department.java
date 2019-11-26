package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Hospital hospital;
    private String departmentID;
    private String departmentName;
    private int maxCapacity;
    private ArrayList<Room> rooms;
    private ArrayList<Doctor> doctors;
    private ArrayList<MedicalEventType> medicalEventTypes;
    
    public Department (Hospital hospital, String departmentID, String departmentName, int maxCapacity)
    {
    	this.hospital=hospital;
    	this.departmentID=departmentID;
    	this.departmentName=departmentName;
    	this.maxCapacity=maxCapacity;
    	this.rooms=new ArrayList<Room>();
    	this.doctors=new ArrayList<Doctor>();
    	this.medicalEventTypes=new ArrayList<MedicalEventType>();
    }
    
    public Department ( String departmentID) {
    	this.departmentID=departmentID;
    }
    
    public Department ( String departmentID, String departmentName) {
    	this.departmentID=departmentID;
    	this.departmentName=departmentName;
    }

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public ArrayList<MedicalEventType> getMedicalEventTypes() {
		return medicalEventTypes;
	}

	public void setMedicalEventTypes(ArrayList<MedicalEventType> medicalEventTypes) {
		this.medicalEventTypes = medicalEventTypes;
	}
	
	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentID == null) ? 0 : departmentID.hashCode());
		result = prime * result + ((hospital == null) ? 0 : hospital.hashCode());
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
		Department other = (Department) obj;
		if (departmentID == null) {
			if (other.departmentID != null)
				return false;
		} else if (!departmentID.equals(other.departmentID))
			return false;
		if (hospital == null) {
			if (other.hospital != null)
				return false;
		} else if (!hospital.equals(other.hospital))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Department [hospital=" + hospital + ", departmentID=" + departmentID + ", departmentName="
				+ departmentName + ", maxCapacity=" + maxCapacity + ", rooms=" + rooms + ", doctors=" + doctors
				+ ", medicalEventTypes=" + medicalEventTypes + "]";
	}
    
}
