package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hospital hospital;
	private Department department;
	private int roomNumber;
	private int bedsAmount;
	private ArrayList<Hospitalized> hospitalizedPatients;
	
	public Room(Hospital hospital, Department department, int roomNumber, int bedsAmount)
	{
		this.hospital=hospital;
		this.department=department;
		this.roomNumber=roomNumber;
		this.bedsAmount=bedsAmount;
		this.hospitalizedPatients=new ArrayList<Hospitalized>();
	}
	
	public Room(Hospital hospital, Department department, int roomNumber)
	{
		this.hospital=hospital;
		this.department=department;
		this.roomNumber=roomNumber;
		this.hospitalizedPatients=new ArrayList<Hospitalized>();
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

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getBedsAmount() {
		return bedsAmount;
	}

	public void setBedsAmount(int bedsAmount) {
		this.bedsAmount = bedsAmount;
	}

	public ArrayList<Hospitalized> getHospitalizedPatients() {
		return hospitalizedPatients;
	}

	public void setHospitalizedPatients(ArrayList<Hospitalized> hospitalizedPatients) {
		this.hospitalizedPatients = hospitalizedPatients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((hospital == null) ? 0 : hospital.hashCode());
		result = prime * result + roomNumber;
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
		Room other = (Room) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (hospital == null) {
			if (other.hospital != null)
				return false;
		} else if (!hospital.equals(other.hospital))
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [hospital=" + hospital + ", department=" + department + ", roomNumber=" + roomNumber
				+ ", bedsAmount=" + bedsAmount + ", hospitalizedPatients=" + hospitalizedPatients + "]";
	}

}
