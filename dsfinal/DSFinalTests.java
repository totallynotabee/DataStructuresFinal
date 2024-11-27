package dsfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

/** Data Structures Final Unit Tests
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

class DSFinalTests {
	
	@Test
	// Test queue time with one appointment added
	void testQueueTime1() {
		// Arrange
		VetQueue testQueue = new VetQueue();
		
		String type = "dog";
		List<String> services = new ArrayList<>();
		services.add("vaccine");
		services.add("checkup");
		
		int expected = 22;
		// Act
		testQueue.addToQueue(type, services);
		int actual = testQueue.getQueueTime();
		// Assert
		assertEquals(actual, expected);
	}
	
	@Test
	// Test queue time with three appointments added and one removed
	void testQueueTime2() {
		// Arrange
		VetQueue testQueue = new VetQueue();
		
		String type1 = "dog";
		List<String> services1 = new ArrayList<>();
		services1.add("vaccine");
		services1.add("checkup");
		
		String type2 = "bird";
		List<String> services2 = new ArrayList<>();
		services2.add("surgery");
		
		String type3 = "cat";
		List<String> services3 = new ArrayList<>();
		services3.add("bloodwork");
		services3.add("dentistry");
		
		int expected = 134;
		// Act
		testQueue.addToQueue(type1, services1);
		testQueue.addToQueue(type2, services2);
		testQueue.addToQueue(type3, services3);
		testQueue.removeFromQueue();
		int actual = testQueue.getQueueTime();
		// Assert
		assertEquals(actual, expected);
	}
	
	@Test
	// Test pet toString with all variables entered
	void testPetCreated() {
		// Arrange
		Pet testPet = new Pet("Esther", 8, "dog", "Golden-Doodle", "female");
		
		String expected = "Esther is a 8 year old female Golden-Doodle dog.";
		// Act
		String actual = testPet.toString();
		// Assert
		assertEquals(actual, expected);
	}
	
	@Test
	// Test pet toString with only a couple variables entered
	void testPetCreated2() {
		// Arrange
		Pet testPet = new Pet("Esther", 8, "dog", null, null);
		
		String expected = "Esther is a 8 year old dog.";
		// Act
		String actual = testPet.toString();
		// Assert
		assertEquals(actual, expected);
	}
	
	@Test
	// Test petList allPets string with four pets
	void testPetListAllPets() {
		// Arrange
		PetList testList = new PetList();
		
		Pet testPet1 = new Pet("Esther", 8, "dog", "Golden-Doodle", "female");
		Pet testPet2 = new Pet("Gogurt", 6, "bird", "Parakeet", "female");
		Pet testPet3 = new Pet("Toothless", 3, "cat", "Black", "male");
		Pet testPet4 = new Pet("Rigby", 1, "cat", "Brown", "male");
		
		String expected = "Esther is a 8 year old female Golden-Doodle dog.\nGogurt is a 6 year old female Parakeet bird.\n"
				+ "Toothless is a 3 year old male Black cat.\nRigby is a 1 year old male Brown cat.\n";
		// Act
		testList.add(testPet1);
		testList.add(testPet2);
		testList.add(testPet3);
		testList.add(testPet4);
		String actual = testList.allPets();
		// Assert
		assertEquals(actual, expected);
	}
	
	@Test
	// Test petList allPets string with four pets sorted by age
	void testPetListAgeSort() {
		// Arrange
		PetList testList = new PetList();
		
		Pet testPet1 = new Pet("Esther", 8, "dog", "Golden-Doodle", "female");
		Pet testPet2 = new Pet("Gogurt", 6, "bird", "Parakeet", "female");
		Pet testPet3 = new Pet("Toothless", 3, "cat", "Black", "male");
		Pet testPet4 = new Pet("Rigby", 1, "cat", "Brown", "male");
		
		String expected = "Rigby is a 1 year old male Brown cat.\nToothless is a 3 year old male Black cat.\n"
				+ "Gogurt is a 6 year old female Parakeet bird.\nEsther is a 8 year old female Golden-Doodle dog.\n";
		// Act
		testList.add(testPet1);
		testList.add(testPet2);
		testList.add(testPet3);
		testList.add(testPet4);
		testList.sortByAge();
		String actual = testList.allPets();
		// Assert
		assertEquals(actual, expected);
	}
	
	@Test
	// Test petList allPets string with four pets sorted by name
	void testPetListNameSort() {
		// Arrange
		PetList testList = new PetList();
		
		Pet testPet1 = new Pet("Esther", 8, "dog", "Golden-Doodle", "female");
		Pet testPet2 = new Pet("Gogurt", 6, "bird", "Parakeet", "female");
		Pet testPet3 = new Pet("Toothless", 3, "cat", "Black", "male");
		Pet testPet4 = new Pet("Rigby", 1, "cat", "Brown", "male");
		
		String expected = "Esther is a 8 year old female Golden-Doodle dog.\nGogurt is a 6 year old female Parakeet bird.\n"
				+ "Rigby is a 1 year old male Brown cat.\nToothless is a 3 year old male Black cat.\n";
		// Act
		testList.add(testPet1);
		testList.add(testPet2);
		testList.add(testPet3);
		testList.add(testPet4);
		testList.sortByName();
		String actual = testList.allPets();
		// Assert
		assertEquals(actual, expected);
	}
	
	@Test
	// Test petList allPets string with four pets sorted by type
	void testPetListTypeSort() {
		// Arrange
		PetList testList = new PetList();
		
		Pet testPet1 = new Pet("Esther", 8, "dog", "Golden-Doodle", "female");
		Pet testPet2 = new Pet("Gogurt", 6, "bird", "Parakeet", "female");
		Pet testPet3 = new Pet("Toothless", 3, "cat", "Black", "male");
		Pet testPet4 = new Pet("Rigby", 1, "cat", "Brown", "male");
		
		String expected = "Gogurt is a 6 year old female Parakeet bird.\nRigby is a 1 year old male Brown cat.\n"
				+ "Toothless is a 3 year old male Black cat.\nEsther is a 8 year old female Golden-Doodle dog.\n";
		// Act
		testList.add(testPet1);
		testList.add(testPet2);
		testList.add(testPet3);
		testList.add(testPet4);
		testList.sortByType();
		String actual = testList.allPets();
		// Assert
		assertEquals(actual, expected);
	}
	
	@Test
	// Test petList allPets string with four pets sorted by gender
	void testPetListGenderSort() {
		// Arrange
		PetList testList = new PetList();
		
		Pet testPet1 = new Pet("Esther", 8, "dog", "Golden-Doodle", "female");
		Pet testPet2 = new Pet("Gogurt", 6, "bird", "Parakeet", "female");
		Pet testPet3 = new Pet("Toothless", 3, "cat", "Black", "male");
		Pet testPet4 = new Pet("Rigby", 1, "cat", "Brown", "male");
		
		String expected = "Gogurt is a 6 year old female Parakeet bird.\nEsther is a 8 year old female Golden-Doodle dog.\n"
				+ "Rigby is a 1 year old male Brown cat.\nToothless is a 3 year old male Black cat.\n";
		// Act
		testList.add(testPet1);
		testList.add(testPet2);
		testList.add(testPet3);
		testList.add(testPet4);
		testList.sortByGender();
		String actual = testList.allPets();
		// Assert
		assertEquals(actual, expected);
	}
}
