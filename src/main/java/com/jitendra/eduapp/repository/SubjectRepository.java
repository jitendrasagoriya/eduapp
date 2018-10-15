package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Subject;
/**
 * @author jitendra sagoriya
 *
 */
@Repository(value="subject")
public interface SubjectRepository extends JpaRepository<Subject, Long> {

 
}
