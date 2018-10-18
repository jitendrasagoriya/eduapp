package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitendra.eduapp.domin.QuestionStat;
import com.jitendra.eduapp.domin.key.QuestionStatPromeryKey;

public interface QuestionStatRepository extends JpaRepository<QuestionStat, QuestionStatPromeryKey> {

}
