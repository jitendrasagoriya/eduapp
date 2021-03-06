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
import com.jitendra.eduapp.service.impl.ChapterServiceImpl;


/**
 * @author jitendra sagoriya
 *
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/chapter/",produces= {MediaType.APPLICATION_JSON_VALUE})
public class ChapterEndpoint {
	
	public static Logger logger = LoggerFactory.getLogger(ChapterEndpoint.class);
	
	@Autowired
	private ChapterServiceImpl chapterService;

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Chapter chapter = chapterService.getById(id);
		if (chapter == null) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		} else {
			return new ResponseEntity< >(chapter, HttpStatus.OK);
		}
	}
	
	@GetMapping("/resume/{classz}")
	public ResponseEntity<?> getResumeChapter(@PathVariable("classz")String classz) {		 
			return new ResponseEntity<>( chapterService.getResume(classz), HttpStatus.OK);
		 
	}
	
	@GetMapping("/subject/{id}")
	public ResponseEntity<?> getSubjectId(@PathVariable("id") Long id,Pageable pageable) {		 
			return new ResponseEntity<>( chapterService.getByNameSubject(Long.toString(id),pageable), HttpStatus.OK);
		 
	}
	
	@GetMapping("/class/{classz}")
	public ResponseEntity<?> getByClass(@PathVariable("classz")String classz,Pageable pageable) {		 
			return new ResponseEntity<>( chapterService.getByClass( classz,pageable), HttpStatus.OK);
		 
	}
	
	@GetMapping("/subject/{id}/class/{classz}")
	public ResponseEntity<?> getSubjectId(@PathVariable("id") Long id,@PathVariable("classz")String classz,Pageable pageable) {		 
			return new ResponseEntity<>( chapterService.getByNameSubjectAndClass(Long.toString(id),classz,pageable), HttpStatus.OK);
		 
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
	
	
	@PutMapping("/resume/false")
	public ResponseEntity<?> updateResumeFalse() {
		try {
			chapterService.updateResumeFalse();
			return new ResponseEntity<>("Successfully update all resume to false", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		
	}
	
	@PutMapping("resume/{id}")
	public ResponseEntity<?> updateResume(@PathVariable("id") Long id) {
		try {
			chapterService.updateResume(id);
			return new ResponseEntity<>("Successfully updateresume to chapter id :"+id, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete( @PathVariable("id") Long id ) {
		Boolean result = chapterService.delete(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("download/csv")
	public ResponseEntity<File> downloadCSV(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/csv");
		response.setHeader("content-disposition", "attachment;filename=chapter.csv");
		ServletOutputStream writer = null;
		try {
			writer = response.getOutputStream();
			logger.info("downloading contents to csv"); 

			writer.print( chapterService.downlaod().toString());
			 
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
