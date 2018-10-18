package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitendra.eduapp.domin.VideoStat;
import com.jitendra.eduapp.domin.key.VideoStatPrimaryKey;

public interface VideoStatRepository extends JpaRepository<VideoStat, VideoStatPrimaryKey> {

}
