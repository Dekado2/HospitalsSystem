package model;

import java.io.Serializable;
import java.util.Date;

public class Hospitalized implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Patient patient;
	private MedicalEvent medicalEvent;
	private int numberOfDays;
	private Date dateOfArrival;
	private int severityLevel;
	private Room room;
	
	public Hospitalized (Patient patient, MedicalEvent medicalEvent, int numberOfDays, Date dateOfArrival, int severityLevel, Room room)
	{
		this.patient=patient;
		this.medicalEvent=medicalEvent;
		this.numberOfDays=numberOfDays;
		this.dateOfArrival=dateOfArrival;
		this.severityLevel=severityLevel;
		this.room=room;
	}
	
	public Hospitalized (Patient patient, MedicalEvent medicalEvent)
	{
		this.patient=patient;
		this.medicalEvent=medicalEvent;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public MedicalEvent getMedicalEvent() {
		return medicalEvent;
	}

	public void setMedicalEvent(MedicalEvent medicalEvent) {
		this.medicalEvent = medicalEvent;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public int getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(int severityLevel) {
		this.severityLevel = severityLevel;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((medicalEvent == null) ? 0 : medicalEvent.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
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
		Hospitalized other = (Hospitalized) obj;
		if (medicalEvent == null) {
			if (other.medicalEvent != null)
				return false;
		} else if (!medicalEvent.equals(other.medicalEvent))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hospitalized [patient=" + patient + ", medicalEvent=" + medicalEvent + ", numberOfDays=" + numberOfDays
				+ ", dateOfArrival=" + dateOfArrival + ", severityLevel=" + severityLevel + ", room=" + room + "]";
	}

}
