package dsfinal;

import java.util.*;

/** Program driver, serves no actual purpose in program, just meant to testing purposes
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

public class Driver {

	public static void main(String[] args) {
		VetQueue test =  new VetQueue();
		List<String> services = new ArrayList<String>();
		services.add("surgery");
		services.add("xray");
		
		System.out.println(test.getQueueTime());
		test.addToQueue("cat", services);
		System.out.println(test.getQueueTime());
		test.removeFromQueue();
		System.out.println(test.getQueueTime());
		
		Pet newPet = new Pet("Esther", 5, "dog", null, "female");
		Pet newPet2 = new Pet("Trixie", 15, "dog", null, "female");
		Pet newPet3 = new Pet("Gogurt", 8, "bird", null, "female");
		Pet newPet4 = new Pet("Toothless", 3, "cat", null, "male");
		Pet newPet5 = new Pet("Rigby", 1, "cat", null, "male");
		
		//System.out.println(newPet.toString());
		
		PetList testPets = new PetList();
		testPets.add(newPet);
		testPets.add(newPet2);
		testPets.add(newPet3);
		testPets.add(newPet4);
		testPets.add(newPet5);
		
		System.out.println(testPets.allPets());
		
		testPets.sortByAge();
		
		System.out.println("\n\n" + testPets.allPets());
		
		testPets.sortByName();
		
		System.out.println("\n\n" + testPets.allPets());
		
		testPets.sortByType();
		
		System.out.println("\n\n" + testPets.allPets());
		
		testPets.sortByGender();
		
		System.out.println("\n\n" + testPets.allPets());
	}

}
