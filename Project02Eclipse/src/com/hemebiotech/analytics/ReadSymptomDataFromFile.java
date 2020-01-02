package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple brute force implementation
 * Reads symptom data from a file that contains symptoms, one per line.
 * @see ISymptomReader
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line 
	 */
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Reads files and stores their data in a sorted ArrayList
	 * @return a list of symptoms fetched from a data source. Duplicated elements may be present
	 */
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
					//Sort the ArrayList alphabetically
					Collections.sort(result);
				}
				
				reader.close();
			} catch (IOException e) {
				System.out.println("File not found. No such file or directory.");
				e.printStackTrace();
			}	
		}
		return result;
	}

}