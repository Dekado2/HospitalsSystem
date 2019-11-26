package model;

import java.io.Serializable;

public class Payments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int serialNumber;
	private int minDay;
	private int maxDay;
	private int amount;
	
	public Payments (int serialNumber, int minDay, int maxDay, int amount)
	{
		this.serialNumber=serialNumber;
		this.minDay=minDay;
		this.maxDay=maxDay;
		this.amount=amount;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getMinDay() {
		return minDay;
	}

	public void setMinDay(int minDay) {
		this.minDay = minDay;
	}

	public int getMaxDay() {
		return maxDay;
	}

	public void setMaxDay(int maxDay) {
		this.maxDay = maxDay;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serialNumber;
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
		Payments other = (Payments) obj;
		if (serialNumber != other.serialNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payments [serialNumber=" + serialNumber + ", minDay=" + minDay + ", maxDay=" + maxDay + ", amount="
				+ amount + "]";
	}

}
