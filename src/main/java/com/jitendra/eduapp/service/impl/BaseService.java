package com.jitendra.eduapp.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.domin.Subject;

public abstract class BaseService<T>   {
	
	public  File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}	
	
	public abstract StringBuffer downlaod();
	
	public abstract List<T> uploadFile(MultipartFile multipartFile) throws IOException;

}
