package model;

import java.io.Serializable;

import utils.E_DayInWeek;
import utils.E_ShiftType;

public class Shift implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shiftNumber;
	private E_DayInWeek dayInWeek;
	private E_ShiftType shiftType;
	
	public Shift (int shiftNumber, E_DayInWeek dayInWeek, E_ShiftType shiftType)
	{
		this.shiftNumber=shiftNumber;
		this.dayInWeek=dayInWeek;
		this.shiftType=shiftType;
	}
	
	public Shift (int shiftNumber)
	{
		this.shiftNumber=shiftNumber;
	}

	public int getShiftNumber() {
		return shiftNumber;
	}

	public void setShiftNumber(int shiftNumber) {
		this.shiftNumber = shiftNumber;
	}

	public E_DayInWeek getDayInWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(E_DayInWeek dayInWeek) {
		this.dayInWeek = dayInWeek;
	}

	public E_ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(E_ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shiftNumber;
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
		Shift other = (Shift) obj;
		if (shiftNumber != other.shiftNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shift [shiftNumber=" + shiftNumber + ", dayInWeek=" + dayInWeek + ", shiftType=" + shiftType
				+ "]";
	}


}
