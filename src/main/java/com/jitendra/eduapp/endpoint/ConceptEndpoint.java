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

import com.jitendra.eduapp.domin.Concept;
import com.jitendra.eduapp.service.impl.ConceptServiceImpl;


/**
 * @author jitendra sagoriya
 *
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/concept/")
public class ConceptEndpoint {
	
	public static Logger logger = LoggerFactory.getLogger(ConceptEndpoint.class);
	
	@Autowired
	private ConceptServiceImpl conceptService; 

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
	
	@GetMapping("download/csv")
	public ResponseEntity<File> downloadCSV(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/csv");
		response.setHeader("content-disposition", "attachment;filename=concept.csv");
		ServletOutputStream writer = null;
		try {
			writer = response.getOutputStream();
			logger.info("downloading contents to csv"); 

			writer.print( conceptService.downlaod().toString());
			 
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
