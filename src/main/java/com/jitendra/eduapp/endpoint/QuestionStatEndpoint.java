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

import com.jitendra.eduapp.domin.QuestionStat;
import com.jitendra.eduapp.domin.key.QuestionStatPromeryKey;
import com.jitendra.eduapp.service.QuestionStatService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/question/stat/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class QuestionStatEndpoint {

	@Autowired
	private QuestionStatService service;

	@GetMapping("{sid}/{cid}")
	public ResponseEntity<?> get(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		QuestionStatPromeryKey id = new QuestionStatPromeryKey(sId, cId);
		try {
			QuestionStat questionStat = service.getById(id);
			if (questionStat == null || questionStat.getId() == null || questionStat.getId().getQuestionId() == null
					|| questionStat.getId().getStudentId() == null) {
				return new ResponseEntity<String>("No such element found", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(questionStat, HttpStatus.OK);
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
	public ResponseEntity<?> save(@RequestBody QuestionStat questionStat) {
		return new ResponseEntity<>(service.save(questionStat), HttpStatus.OK);
	}

	@DeleteMapping("{sid}/{cid}")
	public ResponseEntity<?> delete(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		QuestionStatPromeryKey id = new QuestionStatPromeryKey(sId, cId);
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
