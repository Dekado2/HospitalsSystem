package utils;

public enum E_ShiftType {
	
	MORNING ("Morning"),
	EVENING ("Evening");
	
	private String text;
	
	 E_ShiftType (String text)
	{
		this.text=text;
	}
	
	public String toString() 
	{
		return text;
	}

}
