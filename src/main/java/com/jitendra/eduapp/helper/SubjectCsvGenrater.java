package com.jitendra.eduapp.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Subject;


@Service
public class SubjectCsvGenrater extends CsvFileHelper<Subject> {
	
	
	@Override
	public String iterateObject(List<Subject> t) {
		StringBuffer buffer = new StringBuffer();
		
		for (Subject subject : t) {
			buffer.append(String.valueOf(subject.getId()));
			buffer.append(COMMA_DELIMITER);
			buffer.append(String.valueOf(subject.getName()));
			buffer.append(NEW_LINE_SEPARATOR);
		} 
		return buffer.toString();
	}

	@Override
	public String getFileName() {
		return this.getClass().getName();
	}
	
	
	public static void main(String[] args) {
		Subject subject = new Subject();
		subject.setId(1l);
		subject.setName("CSVTEST");
		
		List<Subject> subjects = new ArrayList<>();
		subjects.add(subject);
		
		SubjectCsvGenrater csvGenrater = new SubjectCsvGenrater();
		try {
			System.out.println( csvGenrater.writeCsvFile(subjects));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Resource loadEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
 
}
