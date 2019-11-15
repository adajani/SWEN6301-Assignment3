package com.swen6301.builder.patient;

public enum BloodType {
	A_PLUS("A+"), 
	A_MINUS("A-"), 
	B_PLUS("B+"), 
	B_MINUS("B-"), 
	AB_PLUS("AB+"), 
	AB_MINUS("AB-"), 
	O_PLUS("O+"), 
	O_MINUS("O-"), 
	NONE("none");

	private String type;

	private BloodType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
	
	public static BloodType getEnum(String type) throws IllegalArgumentException {
		for(BloodType booldValue : values()) {
			if(booldValue.getType().equalsIgnoreCase(type)) {
				return booldValue;
			}
		}
		return BloodType.NONE;
	}	
}
