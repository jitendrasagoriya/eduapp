package com.jitendra.eduapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.domin.Subject;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface SubjectService {
	
	public Page<Subject> getAll(Pageable pageable);
	
	public List<Subject> getAll();
	
	public Subject getById(Long id);
	
	public Subject getByName(Long id);
	
	public Subject save(Subject subject);
	
	public void delete(Long id);
	
	public Subject update(Subject subject);
	
	

}
