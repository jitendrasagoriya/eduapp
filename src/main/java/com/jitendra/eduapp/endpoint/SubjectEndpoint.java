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

import com.jitendra.eduapp.domin.Subject;
import com.jitendra.eduapp.service.SubjectService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/subject/")
public class SubjectEndpoint {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Subject subject = subjectService.getById(id);
		if (subject == null) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		} else {
			return new ResponseEntity< >(subject, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable) {
		return new ResponseEntity<>(subjectService.getAll(pageable), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid Subject subject) {
		return new ResponseEntity<>(subjectService.save(subject), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody @Valid Subject subject) {
		return new ResponseEntity<>(subjectService.save(subject), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete( @PathVariable("id") Long id ) {
		//subjectService.save(subject)
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}

}
