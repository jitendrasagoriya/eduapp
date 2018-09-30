package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Subject;

@Repository(value="subject")
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
