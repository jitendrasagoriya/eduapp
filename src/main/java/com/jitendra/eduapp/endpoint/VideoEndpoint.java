package com.jitendra.eduapp.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.eduapp.domin.Video;
import com.jitendra.eduapp.service.VideoService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/video/")
public class VideoEndpoint {
	
	@Autowired
	private VideoService videoService;
	
	 

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Video video = videoService.getById(id);
		if (video == null) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		} else {			
			return new ResponseEntity< >(video, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable) {
		return new ResponseEntity<>(videoService.getAll(pageable), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid Video video) {
		return new ResponseEntity<>(videoService.save(video), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody @Valid Video video) {
		return new ResponseEntity<>(videoService.save(video), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete( @PathVariable("id") Long id ) {
		//subjectService.save(subject)
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}

}