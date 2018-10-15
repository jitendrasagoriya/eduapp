package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Video;

/**
 * @author jitendra sagoriya
 *
 */
@Repository(value="video")
public interface VideoRepository extends JpaRepository<Video, Long> {	
	
	@Query("SELECT MAX(V.sequence) FROM Video V WHERE V.chapterId = :chapterId")
	public Integer getMax(@Param("chapterId") Long chapterId);
}
