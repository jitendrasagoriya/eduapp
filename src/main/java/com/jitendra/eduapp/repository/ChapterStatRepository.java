package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitendra.eduapp.domin.ChapterStat;
import com.jitendra.eduapp.domin.key.ChapterStatPrimaryKey;

public interface ChapterStatRepository extends JpaRepository<ChapterStat, ChapterStatPrimaryKey> {

}
