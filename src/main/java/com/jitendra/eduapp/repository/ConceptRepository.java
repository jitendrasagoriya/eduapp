package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Concept;
/**
 * @author jitendra sagoriya
 *
 */
@Repository(value="concept")
public interface ConceptRepository extends JpaRepository<Concept, Long>{
	
	@Query("SELECT MAX(C.sequence) FROM Concept C WHERE C.chapterId = :chapterId")
	public Integer getMax(@Param("chapterId") Long chapterId);

}
