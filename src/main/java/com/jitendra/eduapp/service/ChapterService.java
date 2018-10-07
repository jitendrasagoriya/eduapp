package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Chapter;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface ChapterService {
	
	public Page<Chapter> getAll(Pageable pageable);

	public List<Chapter> getAll();

	public Chapter getById(Long id);

	public Page<Chapter> getByNameSubject(String id,Pageable pageable);
	
	public Page<Chapter> getByNameSubjectAndClass(String id,String classz,Pageable pageable);
	
	public Page<Chapter> getByClass(String classz,Pageable pageable);
	
	public List<Chapter> getAll(String id);

	public Chapter save(Chapter chapter);

	public Boolean delete(Long id);

	public Chapter update(Chapter chapter);
	
	public Integer getMax(String subject,String classz);
	
	public int updateVideoCount(Long id);

	public int updateQuestionCount(Long id);

	public int updateConceptCount(Long id);
	
	public int reduceVideoCount(Long id);

	public int reduceQuestionCount(Long id);

	public int reduceConceptCount(Long id);
	
	
	
	
	
	public int updateVideoCount(Long id,Integer count);

	public int updateQuestionCount(Long id,Integer count);

	public int updateConceptCount(Long id,Integer count);
	
	public int reduceVideoCount(Long id,Integer count);

	public int reduceQuestionCount(Long id,Integer count);

	public int reduceConceptCount(Long id,Integer count);
	
	

}
