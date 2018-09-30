package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Question;

@Repository(value="question")
public interface QuestionRepository   extends JpaRepository<Question, Long> {

}
