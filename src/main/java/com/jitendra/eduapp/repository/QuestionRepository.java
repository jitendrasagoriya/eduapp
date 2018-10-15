package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Question;
/**
 * @author jitendra sagoriya
 *
 */
@Repository(value="question")
public interface QuestionRepository   extends JpaRepository<Question, Long> {
	
	@Query("SELECT MAX(Q.sequence) FROM Question Q WHERE Q.chapterId = :chapterId")
	public Integer getMax(@Param("chapterId") Long chapterId);

}
