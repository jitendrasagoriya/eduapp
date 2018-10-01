package com.jitendra.eduapp.dao;

import org.springframework.stereotype.Service;

@Service
public interface BaseDaoService<T> {
	
	public T getRepository();

}
