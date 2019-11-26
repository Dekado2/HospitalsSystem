package utils;

public enum E_DayInWeek {
	
	SUNDAY ("Sunday"),
	MONDAY ("Monday"),
	TUESDAY ("Tuesday"),
	WEDNESDAY ("Wednesday"),
	THURSDAY ("Thursday"),
	FRIDAY ("Friday"),
	SATURDAY ("Saturday");
	
	private String text;
	
	 E_DayInWeek (String text)
	{
		this.text=text;
	}
	
	public String toString() 
	{
		return text;
	}

}
