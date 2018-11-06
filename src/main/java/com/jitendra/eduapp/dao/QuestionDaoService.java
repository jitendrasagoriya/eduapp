package com.jitendra.eduapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Question;
import com.jitendra.eduapp.enums.QuestionType;
import com.jitendra.eduapp.repository.QuestionRepository;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface QuestionDaoService extends BaseDaoService<QuestionRepository> {
	
	public Page<Question> getByChapter(String id,Pageable pageable);

	Page<Question> getByChapter(String id, QuestionType type, Pageable pageable);

}
