package com.jitendra.eduapp.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.constants.Constant;
import com.jitendra.eduapp.dao.VideoDaoService;
import com.jitendra.eduapp.domin.Subject;
import com.jitendra.eduapp.domin.Video;
import com.jitendra.eduapp.service.ChapterService;
import com.jitendra.eduapp.service.NativeQueryService;
import com.jitendra.eduapp.service.VideoService;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public class VideoServiceImpl extends BaseService<Video> implements VideoService {
	
	public static Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);
	
	@Autowired
	private VideoDaoService daoService;
	
	@Autowired
	private ChapterService  chapterService;

	@Override
	public Page<Video> getAll(Pageable pageable) {
		return daoService.getRepository().findAll(pageable);
	}

	@Override
	public List<Video> getAll() {
		return daoService.getRepository().findAll();
	}

	@Override
	public Video getById(Long id) {
		return daoService.getRepository().getOne(id);
	}

	@Override
	public Video getByName(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video save(Video video) {
		video = daoService.getRepository().save(video);		
		try {			
			if(video.getId() != null ) {	
				video.setSequence(getMax(video.getChapterId())==null?1:getMax(video.getChapterId())+1);
				chapterService.updateVideoCount(video.getChapterId());
			}
		}catch (Exception e) {
			logger.error(e.getMessage() );
		}
		return video;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			daoService.getRepository().deleteById(id);
			
			chapterService.reduceVideoCount(id);
			return Boolean.TRUE;
		}catch (Exception e) {
			logger.error("No such elenemt found. Id: "+id);
			return Boolean.FALSE;
		}
	}

	@Override
	public Video update(Video video) {
		return daoService.getRepository().save(video);
	}

	@Override
	public Page<Video> getAllByChapter(Long id, Pageable pageable) {
		return daoService.getAllByChapter(id, pageable);
	}

	@Override
	public StringBuffer downlaod() {
		List<Video> videos = getAll();
		StringBuffer stringBuffer = new StringBuffer();
		for (Video video : videos) {
			stringBuffer.append(video.getId());
			stringBuffer.append(Constant.COMMA_DELIMITER);
			stringBuffer.append(video.getName());
			stringBuffer.append(Constant.COMMA_DELIMITER);			
			stringBuffer.append(video.getDescription());
			stringBuffer.append(Constant.COMMA_DELIMITER);			
			stringBuffer.append(video.getLink());
			stringBuffer.append(Constant.COMMA_DELIMITER);			
			stringBuffer.append(video.getChapterId());
			stringBuffer.append(Constant.NEW_LINE_SEPARATOR);
			
		}
		return stringBuffer;
	}

	@Override
	public List<Video> uploadFile(MultipartFile multipartFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMax(Long id) {
		return daoService.getRepository().getMax(id);
	}

	 
	
	

}
