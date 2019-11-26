package model;

import java.io.Serializable;
import java.util.Date;

public class CheckedBy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Hospitalized hospitalizedPatient;
    private WorksInShift doctorInShift;
    private Date checkTime;
    private double bodyTemp;
    private String bloodPressure;
    
    public CheckedBy(Hospitalized hospitalizedPatient, WorksInShift doctorInShift, Date checkTime, double bodyTemp, String bloodPressure)
    {
    	this.hospitalizedPatient=hospitalizedPatient;
    	this.doctorInShift=doctorInShift;
    	this.checkTime=checkTime;
    	this.bodyTemp=bodyTemp;
    	this.bloodPressure=bloodPressure;
    }

	public Hospitalized getHospitalizedPatient() {
		return hospitalizedPatient;
	}

	public void setHospitalizedPatient(Hospitalized hospitalizedPatient) {
		this.hospitalizedPatient = hospitalizedPatient;
	}

	public WorksInShift getDoctorInShift() {
		return doctorInShift;
	}

	public void setDoctorInShift(WorksInShift doctorInShift) {
		this.doctorInShift = doctorInShift;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public double getBodyTemp() {
		return bodyTemp;
	}

	public void setBodyTemp(double bodyTemp) {
		this.bodyTemp = bodyTemp;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctorInShift == null) ? 0 : doctorInShift.hashCode());
		result = prime * result + ((hospitalizedPatient == null) ? 0 : hospitalizedPatient.hashCode());
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
		CheckedBy other = (CheckedBy) obj;
		if (doctorInShift == null) {
			if (other.doctorInShift != null)
				return false;
		} else if (!doctorInShift.equals(other.doctorInShift))
			return false;
		if (hospitalizedPatient == null) {
			if (other.hospitalizedPatient != null)
				return false;
		} else if (!hospitalizedPatient.equals(other.hospitalizedPatient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckedBy [hospitalizedPatient=" + hospitalizedPatient + ", doctorInShift=" + doctorInShift
				+ ", checkTime=" + checkTime + ", bodyTemp=" + bodyTemp + ", bloodPressure=" + bloodPressure + "]";
	}
	
}
