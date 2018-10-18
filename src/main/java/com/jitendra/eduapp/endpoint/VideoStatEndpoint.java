package com.jitendra.eduapp.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.eduapp.domin.VideoStat;
import com.jitendra.eduapp.domin.key.VideoStatPrimaryKey;
import com.jitendra.eduapp.service.VideoStatService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/video/stat/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class VideoStatEndpoint {

	@Autowired
	private VideoStatService service;

	@GetMapping("{sid}/{cid}")
	public ResponseEntity<?> get(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		VideoStatPrimaryKey id = new VideoStatPrimaryKey(sId, cId);
		try {
			VideoStat videoStat = service.getById(id);
			if (videoStat == null || videoStat.getId() == null || videoStat.getId().getVideoId() == null
					|| videoStat.getId().getStudentId() == null) {
				return new ResponseEntity<String>("No such element found", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(videoStat, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<?> get(Pageable pageable) {
		return new ResponseEntity<>(service.getAll(pageable), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody VideoStat videoStat) {
		return new ResponseEntity<>(service.save(videoStat), HttpStatus.OK);
	}

	@DeleteMapping("{sid}/{cid}")
	public ResponseEntity<?> delete(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		VideoStatPrimaryKey id = new VideoStatPrimaryKey(sId, cId);
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

}
