package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Chapter;

@Repository(value="chapter")
public interface ChapterRepositroy extends JpaRepository<Chapter, Long> {

}
