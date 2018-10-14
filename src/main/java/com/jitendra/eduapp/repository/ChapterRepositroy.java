package com.jitendra.eduapp.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Chapter;


/**
 * @author jitendra sagoriya
 *
 */
@Repository(value="chapter")
public interface ChapterRepositroy extends JpaRepository<Chapter, Long> {

	@Query("SELECT MAX(C.sequence) FROM Chapter C WHERE C.subject = :subject AND C.classz = :classz")
	public Integer getMax(@Param("subject") String subject,@Param("classz") String classz);
	
	 
	@Modifying
	@Query("update Chapter c set c.videoCount = c.videoCount + :count where c.id = :id")
	public int increaseVideoCount(@Param("id") Long id , @Param("count") Integer count );
	
	@Modifying
	@Query("update Chapter c set c.questionCount = c.questionCount + :count where c.id = :id")
	public int increaseQuestionCount(@Param("id") Long id  , @Param("count") Integer count);
	
	@Modifying
	@Query("update Chapter c set c.conceptCount = c.conceptCount + :count where c.id = :id")
	public int increaseConceptCount(@Param("id") Long id  , @Param("count") Integer count);
	
	
	@Modifying
	@Query("update Chapter c set c.videoCount = c.videoCount - :count where c.id = :id")
	public int reduceVideoCount(@Param("id") Long id  , @Param("count") Integer count);
	
	@Modifying
	@Query("update Chapter c set c.questionCount = c.questionCount - :count where c.id = :id")
	public int reduceQuestionCount(@Param("id") Long id  , @Param("count") Integer count);
	
	@Modifying
	@Query("update Chapter c set c.conceptCount = c.conceptCount - :count where c.id = :id")
	public int reduceConceptCount(@Param("id") Long id  , @Param("count") Integer count);
	
	@Modifying
	@Query("update Chapter c set c.resume = true, c.resumeTimestamp = :time where c.id = :id")
	public int setResume(@Param("id") Long id , @Param("time") Timestamp time );
	
	@Query("SELECT C FROM Chapter C WHERE C.resume = :true order by C.resume desc")
	public Chapter getResume();
	
}
