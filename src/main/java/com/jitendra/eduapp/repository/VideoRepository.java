package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Video;

/**
 * @author jitendra sagoriya
 *
 */
@Repository(value="video")
public interface VideoRepository extends JpaRepository<Video, Long> {

}
