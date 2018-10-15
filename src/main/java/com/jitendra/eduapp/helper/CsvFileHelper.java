package com.jitendra.eduapp.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Subject;

@Service
public abstract class CsvFileHelper<T> {

	 
	// Delimiter used in CSV file
	public static final String COMMA_DELIMITER = ",";
	public static final String NEW_LINE_SEPARATOR = "\n";

	public abstract String iterateObject(List<Subject> subjects);

	public abstract String getFileName();

	public abstract Resource loadEmployees();
	
	File resource = null;

	public File writeCsvFile(List<Subject> subjects) throws IOException {

		File file =   resource = new ClassPathResource(
			      "csv/subject.csv").getFile(); 

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(file);

			// Write the CSV file header
			// fileWriter.append(FILE_HEADER.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			// Write a new student object list to the CSV file
			fileWriter.append(iterateObject(subjects));

			System.out.println("CSV file was created successfully !!!");

			return file;

		} catch (Exception e) {

			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
			return null;
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}
	}

}
