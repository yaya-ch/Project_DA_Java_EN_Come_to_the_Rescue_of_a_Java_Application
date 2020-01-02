package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Counts, sorts alphabetically and writes symptoms and their occurrences to a new generated file
 * @author Yahia CHERIFI
 * @version 1.0.0
 * @see ISymptomWriter
 *
 */

public class WriteSymptomDataToFile implements ISymptomWriter{
	
	private ReadSymptomDataFromFile reader;
	private String outPutFile;
	
	/**
	 * @param symptomFile: file that contains the different symptoms. one in a line.
	 * @param outPutFile: an automatically generated file that stores the different symptoms sorted alphabetically.
	 * with their number of occurrence.
	 */

	public WriteSymptomDataToFile(String symptomFile, String outPutFile) {
		this.reader = new ReadSymptomDataFromFile(symptomFile);
		this.outPutFile = outPutFile;
	}
	
	/**
	 * Counts the ArrayList's elements and store them, without repetition, and their number of occurrence to a TreeMap.
	 * generate a new output file.
	 * writes both the keys and values of the Map to the output file.
	 */
	
	@Override
	public void writeSymptoms() {

		Map<String, Integer> orderedSymptoms = new TreeMap<String, Integer>();
		List<String> symptoms = (ArrayList<String>) reader.getSymptoms();
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outPutFile));
			/*loop through ArrayList symptoms and search for duplicated elements
			add both the elements and their number of occurrence to orderedSymptom TreeMap*/
			
			for (String symp : symptoms) {
				
				//convert symp to lower case to ignore case differences in similar symptoms
				String symptom = symp.toLowerCase();
				if (orderedSymptoms.containsKey(symptom)) {
					orderedSymptoms.put(symptom, orderedSymptoms.get(symptom) + 1);
				} else {
					orderedSymptoms.put(symptom, 1);
				}
			}
			
			//write symptoms and their occurrences to a new generated file
			for (String symptom : orderedSymptoms.keySet()) {
				System.out.println(symptom + " = " + orderedSymptoms.get(symptom));
				writer.write(symptom +" = " + orderedSymptoms.get(symptom) + "\n");
			}
			
			writer.close();
		} catch (IOException e) {
			System.out.println("Ooops, an error occurred.");
			e.printStackTrace();
		}
			
	}
	
}