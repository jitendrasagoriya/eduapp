package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.McqAnswer;


@Repository(value="answer")
public interface McqAnswerRepository extends JpaRepository<McqAnswer, Long> {

}
