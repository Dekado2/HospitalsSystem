package model;

import java.io.Serializable;
import java.util.ArrayList;

public class MedicalEventType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int typeCode;
	private String typeName;
	private ArrayList<Department> departments;
	private ArrayList<MedicalEvent> medicalEvents;
	
	public MedicalEventType (int typeCode, String typeName)
	{
		this.typeCode=typeCode;
		this.typeName=typeName;
		this.departments=new ArrayList<Department>();
		this.medicalEvents=new ArrayList<MedicalEvent>();
	}
	public MedicalEventType (int typeCode) {
		this.typeCode=typeCode;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}

	public ArrayList<MedicalEvent> getMedicalEvents() {
		return medicalEvents;
	}

	public void setMedicalEvents(ArrayList<MedicalEvent> medicalEvents) {
		this.medicalEvents = medicalEvents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + typeCode;
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
		MedicalEventType other = (MedicalEventType) obj;
		if (typeCode != other.typeCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicalEventType [typeCode=" + typeCode + ", typeName=" + typeName + ", departments=" + departments
				+ ", medicalEvents=" + medicalEvents + "]";
	}
	
}
