package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;
/**
 * @author jitendra sagoriya
 *
 */
@Service
public interface BaseDaoService<T> {
	
	public T getRepository();

}
