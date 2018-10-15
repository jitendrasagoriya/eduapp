package com.jitendra.eduapp.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jitendra.eduapp.domin.Subject;
import com.jitendra.eduapp.repository.SubjectRepository;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface SubjectDaoService extends BaseDaoService<SubjectRepository>  {
	
	public void batchStore(List<Subject> subjects);

}
