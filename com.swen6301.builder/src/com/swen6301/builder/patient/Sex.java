package com.swen6301.builder.patient;

public enum Sex {
	FEMALE("female"), 
	MALE("male"),
	NONE("none");
	
	private String value;
	
	private Sex(String value) {	
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public static Sex getEnum(String sex) throws IllegalArgumentException {
		for(Sex sexValue : values()) {
			if(sexValue.getValue().equalsIgnoreCase(sex)) {
				return sexValue;
			}
		}
		return Sex.NONE;
	}
}
