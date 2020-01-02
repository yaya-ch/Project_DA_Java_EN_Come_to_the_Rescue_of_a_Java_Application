package com.hemebiotech.analytics;

/**
 * Anything that will count, organize and write symptom data to a new generated file.
 * @author Yahia CHERIFI
 * @version 1.0.0
 */

public interface ISymptomWriter {
	
	//Generate a new file and write data to it.
	void writeSymptoms();
}