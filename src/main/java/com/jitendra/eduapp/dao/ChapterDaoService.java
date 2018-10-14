package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.repository.ChapterRepositroy;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface ChapterDaoService extends BaseDaoService<ChapterRepositroy> {

	public int updateVideoCount(Long id, Integer count);

	public int updateQuestionCount(Long id, Integer count);

	public int updateConceptCount(Long id, Integer count);

	public int reduceVideoCount(Long id, Integer count);

	public int reduceQuestionCount(Long id, Integer count);

	public int reduceConceptCount(Long id, Integer count);
	
	public int updateResume(Long id);
	
	public void updateResumeFalse();

}
