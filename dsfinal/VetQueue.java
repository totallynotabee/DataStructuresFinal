package dsfinal;

import java.util.*;

/** Vet Queue class, used to create a queue of vet appointments
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

public class VetQueue {
	
	// The default amount of time a visit will take, added to all visits
	private final int DEFAULT_TIME = 5;
	
	// The multiplier thats done at the end based on how challenging a pet will be
	private final double CAT = 1.25;
	private final double DOG = 1.5;
	private final double BIRD = 1.5;
	private final double RODENT = 1;
	
	// Time values for all different types of services and operations
	private final int SURGERY_TIME = 60;
	private final int VACCINE_TIME = 5;
	private final int XRAY_TIME = 15;
	private final int BLOODWORK_TIME = 10;
	private final int DENTISTRY_TIME = 15;
	private final int CHECKUP_TIME = 5;
	
	// Queue object for queuing vet appointments
	private Queue<Integer> vetQueue;
	
	// Constructor to initialize queue
	public VetQueue() {
		vetQueue = new LinkedList<>();
	}
	
	// Remove first item from queue (finish vet appointment). Just uses poll so if there is no appointment, no error is thrown
	public void removeFromQueue() {
		vetQueue.poll();
	}
	
	// Queue time is determined by taking the total of all current queue times
	public int getQueueTime() {
		int queueTime = 0;
		if (!vetQueue.isEmpty()) {
			for (int item : vetQueue) {
				queueTime += item;
			}
		}
		return queueTime;
	}
	
	// Queue time styled is just an hour/minute formatted version of the queue time
	public String getQueueTimeStyled() {
		int queueTime = getQueueTime();
		int queueHours = queueTime/60;
		int queueMins = queueTime%60;
		String queueString = queueHours + "h " + queueMins + "m";
		return queueString;
	}
	
	/*
	 * Add to queue allows an item to be added. Compares the lists of services to a
	 * switch case to see which ones will be added to the servicesTime. The it checks
	 * which type of pet is being serviced to then multiply by the respective multiplier.
	 * Finally, adds time (in minutes) to queue.
	 */
	public void addToQueue(String type, List<String> services) {
		int servicesTime = 0;
		for (String service : services) {
			switch(service) {
			case "surgery":
				servicesTime += SURGERY_TIME;
				break;
			case "vaccine":
				servicesTime += VACCINE_TIME;
				break;
			case "xray":
				servicesTime += XRAY_TIME;
				break;
			case "bloodwork":
				servicesTime += BLOODWORK_TIME;
				break;
			case "dentistry":
				servicesTime += DENTISTRY_TIME;
				break;
			case "checkup":
				servicesTime += CHECKUP_TIME;
				break;
			}
		}
		
		int time;
		switch(type) {
		case "cat":
			time = (int) ((DEFAULT_TIME + servicesTime) * CAT);
			vetQueue.add(time);
			break;
		case "dog":
			time = (int) ((DEFAULT_TIME + servicesTime) * DOG);
			vetQueue.add(time);
			break;
		case "bird":
			time = (int) ((DEFAULT_TIME + servicesTime) * BIRD);
			vetQueue.add(time);
			break;
		case "rodent":
			time = (int) ((DEFAULT_TIME + servicesTime) * RODENT);
			vetQueue.add(time);
			break;
		}
	}
}
