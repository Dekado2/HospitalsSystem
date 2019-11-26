package model;

import java.io.Serializable;

public class WorksInShift implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Doctor doctor;
	private Shift shift;
	
	public WorksInShift (Doctor doctor, Shift shift)
	{
		this.doctor=doctor;
		this.shift=shift;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((shift == null) ? 0 : shift.hashCode());
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
		WorksInShift other = (WorksInShift) obj;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (shift == null) {
			if (other.shift != null)
				return false;
		} else if (!shift.equals(other.shift))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorksInShift [doctor=" + doctor + ", shift=" + shift + "]";
	}

}
