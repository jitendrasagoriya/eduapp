package com.jitendra.eduapp.endpoint;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.domin.Subject;
import com.jitendra.eduapp.service.impl.SubjectServiceImpl;

/**
 * @author jitendra sagoriya
 *
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/subject/")
public class SubjectEndpoint {

	public static Logger logger = LoggerFactory.getLogger(SubjectEndpoint.class);

	@Autowired
	private SubjectServiceImpl subjectService;

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Subject subject = subjectService.getById(id);
		if (subject == null) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(subject, HttpStatus.OK);
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
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		// subjectService.save(subject)
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}

	
	@GetMapping("download/csv")
	public ResponseEntity<File> downloadCSV(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/csv");
		response.setHeader("content-disposition", "attachment;filename=subject.csv");
		ServletOutputStream writer = null;
		try {
			writer = response.getOutputStream();
			logger.info("downloading contents to csv"); 

			writer.print(subjectService.downlaod().toString());
			 
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

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public List<Subject> uploadFile(@RequestPart(value = "file") MultipartFile multiPartFile) throws IOException {
		return subjectService.uploadFile(multiPartFile);
	}
}
