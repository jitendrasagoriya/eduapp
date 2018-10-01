package com.jitendra.eduapp.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.jitendra.eduapp.domin.Concept;
import com.jitendra.eduapp.service.ConceptService;


/**
 * @author jitendra sagoriya
 *
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/concept/")
public class ConceptEndpoint {
	
	@Autowired
	private ConceptService conceptService; 

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Concept concept = conceptService.getById(id);
		if (concept == null) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		} else {			
			return new ResponseEntity< >(concept, HttpStatus.OK);
		}
	}
	

	@GetMapping("/chapter/{id}")
	public ResponseEntity<?> getByChapterId(@PathVariable("id") Long id,Pageable pageable) {
		Page<Concept> video = conceptService.getAllByChapter(id, pageable);
		if (video == null || !video.hasContent()) {
			return new ResponseEntity<String>("No such video found for chapter : "+id, HttpStatus.OK);
		} else {			
			return new ResponseEntity< >(video, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable) {
		return new ResponseEntity<>(conceptService.getAll(pageable), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid Concept concept) {
		return new ResponseEntity<>(conceptService.save(concept), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody @Valid Concept concept) {
		return new ResponseEntity<>(conceptService.save(concept), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete( @PathVariable("id") Long id ) {
		//subjectService.save(subject)
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}

}
