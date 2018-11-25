package com.jitendra.eduapp.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jitendra.eduapp.domin.ChapterStat;
import com.jitendra.eduapp.domin.key.ChapterStatPrimaryKey;

public interface ChapterStatRepository extends JpaRepository<ChapterStat, ChapterStatPrimaryKey> {
	
	@Query("SELECT CS FROM ChapterStat CS WHERE CS.id.studentId = :studentId AND CS.id.chapterId = :chapterId AND CS.resume = true AND CS.modifyDate = MAX(CS.modifyDate)")
	public List<ChapterStat> getChapterResume(@Param("studentId") Long studentId,@Param("chapterId") Long chapterId);
	
	
	@Query("SELECT CS FROM ChapterStat CS WHERE CS.id.studentId = :studentId  AND CS.resume = true AND CS.modifyDate = MAX(CS.modifyDate)")
	public List<ChapterStat> getChapterResume(@Param("studentId") Long studentId );
	 
	@Query("SELECT CS FROM ChapterStat CS WHERE CS.id.studentId = :studentId AND CS.subjectId = :subjectId AND CS.resume = true order by CS.modifyDate desc")
	public List<ChapterStat> getChapterResumeBySubject(@Param("studentId") Long studentId ,@Param("subjectId") Long subjectId );

}
