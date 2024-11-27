package dsfinal;

import java.util.*;

/** List of Pets
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

public class PetList {
	
	// List of pet objects to allow user to have a list of pets
	private List<Pet> petList;
	
	// Constructor to initialize new list
	public PetList() {
		petList = new ArrayList<>();
	}
	
	// Add pet just uses built-in list .add() method
	public void add(Pet pet) {
		petList.add(pet);
	}
	
	// Same goes for remove
	public void remove(Pet pet) {
		petList.remove(pet);
	}
	
	// All pets returns a string of all of the pets. Used for printing in the GUI
	public String allPets() {
		String petString = "";
		for (Pet pet : petList) {
			petString += pet.toString() + "\n";
		}
		return petString;
	}
	
	/*  SORTING METHODS
	 * 
	 * All sorts are done by comparing two lists and placing in a new list based on comparison.
	 * This method of sorting isn't particularly efficient, however, do to the fact that most average
	 * pet owners have less then 5 pets, list sizes will always be relatively small. Comments are only
	 * for first sort, because the rest are the exact same but for a different attribute.
	*/
	
	public void sortByName() {
		List<Pet> tempList = new ArrayList<>(); // Create new temporary list for adding items to
		Pet min; // Create a min object to hold the current minimum value
		int listSize = petList.size(); // The size of the list is saved to a variable so that it stays consistent throughout
		for (int x = 0; x < listSize; x++) { // First loop will loop as many times as there are items
			min = petList.get(0); // min will get set to first (next) item in list
			for (int y = 0; y < petList.size(); y++) { // Second loop will only loop as many times are there are current items
				if (petList.get(y).getPetName().charAt(0) <= min.getPetName().charAt(0)) { // Compares the current item (min) to all other items in the list currently
					min = petList.get(y); // If any other items are smaller, they replace it and take its place
				}
			}
			tempList.add(min); // Once the smallest item is found, it gets added to temp list
			petList.remove(min); // And it is removed from petList. This way, it will add all the items in order of smallest to largest without duplicates
		}
		petList = tempList; // Once done, the petList is reset will the ordered values in the temp list
	}
	
	public void sortByAge() {
		List<Pet> tempList = new ArrayList<>();
		Pet min;
		int listSize = petList.size();
		for (int x = 0; x < listSize; x++) {
			min = petList.get(0);
			for (int y = 0; y < petList.size(); y++) {
				if (petList.get(y).getAge() <= min.getAge()) {
					min = petList.get(y);
				}
			}
			tempList.add(min);
			petList.remove(min);
		}
		petList = tempList;
	}
	
	public void sortByType() {
		List<Pet> tempList = new ArrayList<>();
		Pet min;
		int listSize = petList.size();
		for (int x = 0; x < listSize; x++) {
			min = petList.get(0);
			for (int y = 0; y < petList.size(); y++) {
				if (petList.get(y).getType().charAt(0) <= min.getType().charAt(0)) {
					min = petList.get(y);
				}
			}
			tempList.add(min);
			petList.remove(min);
		}
		petList = tempList;
	}
	
	public void sortByGender() {
		List<Pet> tempList = new ArrayList<>();
		Pet min;
		int listSize = petList.size();
		for (int x = 0; x < listSize; x++) {
			min = petList.get(0);
			for (int y = 0; y < petList.size(); y++) {
				if (petList.get(y).getGender().charAt(0) <= min.getGender().charAt(0)) {
					min = petList.get(y);
				}
			}
			tempList.add(min);
			petList.remove(min);
		}
		petList = tempList;
	}
}
