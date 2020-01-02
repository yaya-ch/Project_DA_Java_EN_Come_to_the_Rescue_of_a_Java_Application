package com.hemebiotech.analytics;

public class AnalyticsCounter {
	
	/**
	 * @author Yahia-CHERIFI
	 *@version 1.0.0
	 */
	
	public static void main(String args[]) {
		System.out.println("Welcome to Analytics Counter\n\n");
		
		ReadSymptomDataFromFile readSymptom = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		System.out.println("Full symptoms's list:\n\n"+ readSymptom.getSymptoms()+ "\n\n");
		
		WriteSymptomDataToFile writeToFile = new WriteSymptomDataToFile("Project02Eclipse/symptoms.txt", "result.out");
		writeToFile.writeSymptoms();
		
		System.out.println("\n\nThank you for using Analytics Counter. See you soon.");
	}
}
