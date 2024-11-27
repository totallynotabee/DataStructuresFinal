package dsfinal;

/** Pet class to create pet objects
 * @author Brendan Coleman 
 * @version 1.0
 * @since 1.0
*/
/*  
* OS: Windows x64
* IDE: Eclipse
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/

public class Pet {
	// Variables
	private String petName;
	private int age;
	private String type;
	private String breed;
	private String gender;
	
	// Constructor (no default or overload needed, because GUI guarantees necessary values are input, other values can be left null and has no affect)
	public Pet(String petName, int age, String type, String breed, String gender) {
		this.petName = petName;
		this.age = age;
		this.type = type;
		this.breed = breed;
		this.gender = gender;
	}

	// Getters and Setters
	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// toString - Returns a string for pet and only returns certain parts if they exist (gender, breed)
	public String toString() {
		String returnString = this.petName + " is a " + this.age + " year old ";
		if (this.gender != null && this.gender != "") {
			returnString += this.gender + " ";
		}
		if (this.breed != null && this.breed != "") {
			returnString += this.breed + " ";
		}
		returnString += this.type + ".";
		return returnString;
	}
}
