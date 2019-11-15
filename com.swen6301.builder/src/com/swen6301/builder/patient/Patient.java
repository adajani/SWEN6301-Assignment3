package com.swen6301.builder.patient;

public class Patient {
	private final String firstName;
	private final String middleName;
	private final String lastName;
	private final int age;
	private final int weight;
	private final Sex sex;
	private final int height;
	private final boolean organDonor;
	private final BloodType bloodType;
	
	private Patient(PatientBuilder builder) {
		this.firstName = builder.firstName;
		this.middleName = builder.middleName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.weight = builder.weight;
		this.sex = Sex.getEnum(builder.sex);
		this.height = builder.height;
		this.organDonor = builder.organDonor;
		this.bloodType = BloodType.getEnum(builder.bloodType);
	}
	
	@Override
	public String toString() {
		return "Patient [" + this.firstName + ", " + this.lastName + "]";
	}
	
	public static class PatientBuilder {
		private String firstName = "";
		private String middleName = "";
		private String lastName = "";
		private int age = 0;
		private int weight = 0;
		private String sex = "";
		private int height = 0;
		private boolean organDonor = false;
		private String bloodType = "";
		
		public PatientBuilder addFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public PatientBuilder addMiddleName(String middleName) {
			this.middleName = middleName;
			return this;
		}
		
		public PatientBuilder addLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public PatientBuilder addAge(int age) {
			this.age = age;
			return this;
		}
		
		public PatientBuilder addWeight(int weight) {
			this.weight = weight;
			return this;
		}
		
		public PatientBuilder addSex(String sex) {
			this.sex = sex;
			return this;
		}
		
		public PatientBuilder addHeight(int height) {
			this.height = height;
			return this;
		}
		
		public PatientBuilder addOrganDonor(boolean organDonor) {
			this.organDonor = organDonor;
			return this;
		}
		
		public PatientBuilder addBloodType(String bloodType) {
			this.bloodType = bloodType;
			return this;
		}		
		
		private void validateInput() {
			// Check whether the firstName is not null and not empty.
			if(this.firstName == null || this.firstName.isEmpty()) {
				throw new IllegalArgumentException("First name cannot be empty of null.");
			}
			
			// Check whether the middleName is no null.
			if(this.middleName == null) {
				throw new IllegalArgumentException("Middle name cannot be null.");
			}
			
			// Check whether the lastName is not null and not empty.
			if(this.lastName == null || this.lastName.isEmpty()) {
				throw new IllegalArgumentException("Last name cannot be empty of null.");
			}
			
			// Check whether the age is between 0 and 120.
			if(this.age < 0 || this.age > 120) {
				throw new IllegalArgumentException("Age cannot be negative or larger than 120.");
			}
			
			// Check whether the weight is between 0 and 300.
			if(this.weight < 0 || this.weight > 300) {
				throw new IllegalArgumentException("Weight cannot negative or larger than 300.");
			}
			
			// Check whether the height is between 0 and 250.
			if(this.height < 0 || this.height > 250) {
				throw new IllegalArgumentException("Height cannot negative or larger than 250.");
			}
			
			// Check whether sex is not null and not empty.
			if(sex == null || sex.isEmpty()) {
				throw new IllegalArgumentException("Sex can only be either 'male', 'female', or 'none'.");
			}
			
			// Check whether the sex is equal to either 'male, 'female', or 'none'.
			if(!"male".equals(sex.toLowerCase()) && !"female".equals(sex.toLowerCase()) && !"none".equals(sex.toLowerCase())) {
				throw new IllegalArgumentException("Sex can only be either 'male', 'female', or 'none'.");
			}

			// Check whether bloodType is not null.
			if(bloodType == null) {
				throw new IllegalArgumentException("Blood type cannot be null.");
			}

			// Check whether bloodType is either A+, A-, B+, B-, O+, O-, AB+, AB-, or 'none'.
			if("a+".equals(bloodType.toLowerCase()) &&
					"a-".equals(bloodType.toLowerCase()) &&
					"b+".equals(bloodType.toLowerCase()) &&
					"b-".equals(bloodType.toLowerCase()) &&
					"ab+".equals(bloodType.toLowerCase()) && 
					"ab-".equals(bloodType.toLowerCase()) &&
					"o+".equals(bloodType.toLowerCase()) &&
					"o-".equals(bloodType.toLowerCase())) {
				throw new IllegalArgumentException("Blood type can be either A+, A-, B+, B-, O+, O-, AB+, AB-, or 'none' in case the patient does not her blood type.");
			}
		}
		
		public Patient build () {
			this.validateInput();
			return new Patient(this);
		}
	}	
}
