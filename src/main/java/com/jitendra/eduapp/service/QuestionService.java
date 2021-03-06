package com.jitendra.eduapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.McqAnswer;
import com.jitendra.eduapp.domin.Question;
import com.jitendra.eduapp.enums.QuestionType;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface QuestionService {
	
	public Page<Question> getAll(Pageable pageable);

	public List<Question> getAll();

	public Question getById(Long id);

	public Page<Question> getByChapter(String id,Pageable pageable);

	public Question save(Question question);

	public Boolean delete(Long id);

	public Question update(Question question) throws Exception;
	
	public Integer getMax(Long id);
	
	public McqAnswer saveMcq(McqAnswer mcqAnswer);
	
	public Boolean deleteMcq(Long id);
	
	public Question next(Integer sequence);
	
	public Question privous(Integer sequence);

	Page<Question> getByChapter(String id, QuestionType type, Pageable pageable);
	 

}
