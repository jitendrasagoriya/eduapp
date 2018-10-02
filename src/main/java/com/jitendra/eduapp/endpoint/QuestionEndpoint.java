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

import com.jitendra.eduapp.domin.Question;
import com.jitendra.eduapp.service.QuestionService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/question/")
public class QuestionEndpoint {
	
	
	@Autowired
	private QuestionService questionService; 

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Question question = questionService.getById(id);
		if (question == null) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		} else {			
			return new ResponseEntity< >(question, HttpStatus.OK);
		}
	}
	

	@GetMapping("/chapter/{id}")
	public ResponseEntity<?> getByChapterId(@PathVariable("id") String id,Pageable pageable) {
		Page<Question> question = questionService.getByChapter(id, pageable);
		if (question == null || !question.hasContent()) {
			return new ResponseEntity<String>("No such video found for chapter : "+id, HttpStatus.OK);
		} else {			
			return new ResponseEntity< >(question, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable) {
		return new ResponseEntity<>(questionService.getAll(pageable), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Valid Question question) {
		return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody @Valid Question question) {
		return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete( @PathVariable("id") Long id ) {
		//subjectService.save(subject)
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}

}
