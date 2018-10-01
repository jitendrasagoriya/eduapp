package com.jitendra.eduapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jitendra.eduapp.dao.NativeQueryDaoService;

@Service
public class NativeQueryDaoServiceImpl implements NativeQueryDaoService {
	
	public static Logger logger = LoggerFactory.getLogger(NativeQueryDaoServiceImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public int insertIntoVideo(Long viodeId,Long chapterId){
		if(logger.isDebugEnabled())  logger.debug(" inside insertIntoVideo start");
		String queryString ="INSERT INTO CHAPTER_COMMENTS CC VALUES (?,?)";
		if(logger.isDebugEnabled())  logger.debug("insertIntoVideo : queryString :"+queryString);
	    Query query = entityManager.createNativeQuery(queryString);
	    query.setParameter(1, viodeId);
	    query.setParameter(2, chapterId);
	    if(logger.isDebugEnabled())  logger.debug("insertIntoVideo : query :"+query);
	    return  query.executeUpdate();
	}

}
