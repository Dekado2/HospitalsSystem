package model;

import java.io.Serializable;

public class MedicalEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eventCode;
	private String description;
	private MedicalEventType medicalEventType;
	
    public MedicalEvent (int eventCode, String description, MedicalEventType medicalEventType)
    {
    	this.eventCode=eventCode;
    	this.description=description;
    	this.medicalEventType=medicalEventType;
    }
    
    public MedicalEvent (int eventCode, String description)
    {
    	this.eventCode=eventCode;
    	this.description=description;
    }
    
    public MedicalEvent (int eventCode)
    {
    	this.eventCode=eventCode;
    }

	public int getEventCode() {
		return eventCode;
	}

	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MedicalEventType getMedicalEventType() {
		return medicalEventType;
	}

	public void setMedicalEventType(MedicalEventType medicalEventType) {
		this.medicalEventType = medicalEventType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventCode;
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
		MedicalEvent other = (MedicalEvent) obj;
		if (eventCode != other.eventCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicalEvent [eventCode=" + eventCode + ", description=" + description + ", medicalEventType="
				+ medicalEventType + "]";
	}
    
    
}
