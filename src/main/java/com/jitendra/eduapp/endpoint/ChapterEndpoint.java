package com.jitendra.eduapp.endpoint;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.eduapp.domin.Chapter;
import com.jitendra.eduapp.service.ChapterService;


/**
 * @author jitendra sagoriya
 *
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/chapter/",produces= {MediaType.APPLICATION_JSON_VALUE})
public class ChapterEndpoint {
	
	@Autowired
	private ChapterService chapterService;

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Chapter chapter = chapterService.getById(id);
		if (chapter == null) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		} else {
			return new ResponseEntity< >(chapter, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable) {
		return new ResponseEntity<>(chapterService.getAll(pageable), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid Chapter chapter) {
		return new ResponseEntity<>(chapterService.save(chapter), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody @Valid Chapter chapter) {
		return new ResponseEntity<>(chapterService.save(chapter), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete( @PathVariable("id") Long id ) {
		Boolean result = chapterService.delete(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
