package com.jitendra.eduapp.endpoint;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.jitendra.eduapp.enums.QuestionType;
import com.jitendra.eduapp.service.impl.QuestionServiceImpl;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/question/")
public class QuestionEndpoint {
	
	public static Logger logger = LoggerFactory.getLogger(QuestionEndpoint.class);
	
	@Autowired
	private QuestionServiceImpl questionService; 

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
			return new ResponseEntity<String>("No questions found for chapter : "+id, HttpStatus.OK);
		} else {			
			return new ResponseEntity< >(question, HttpStatus.OK);
		}
	}
	
	@GetMapping("/mcq/chapter/{id}")
	public ResponseEntity<?> getMcqByChapterId(@PathVariable("id") String id,Pageable pageable) {
		Page<Question> question = questionService.getByChapter(id, QuestionType.MCQ, pageable);
		if (question == null || !question.hasContent()) {
			return new ResponseEntity<String>("No questions found for chapter : "+id, HttpStatus.OK);
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
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("download/csv")
	public ResponseEntity<File> downloadCSV(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/csv");
		response.setHeader("content-disposition", "attachment;filename=question.csv");
		ServletOutputStream writer = null;
		try {
			writer = response.getOutputStream();
			logger.info("downloading contents to csv"); 

			writer.print( questionService.downlaod().toString());
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

}
