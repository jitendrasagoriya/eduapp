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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.eduapp.domin.ChapterStat;
import com.jitendra.eduapp.domin.key.ChapterStatPrimaryKey;
import com.jitendra.eduapp.service.ChapterStatService;

/**
 * @author jitendra sagoriya
 *
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/chapter/stat/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ChapterStatEndpoint {

	@Autowired
	private ChapterStatService service;

	@GetMapping("{sid}/{cid}")
	public ResponseEntity<?> get(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		ChapterStatPrimaryKey id = new ChapterStatPrimaryKey(sId, cId);
		try {
			ChapterStat chapterStat = service.getById(id);
			if (chapterStat == null || chapterStat.getId() == null || chapterStat.getId().getChapterId() == null
					|| chapterStat.getId().getStudentId() == null) {
				return new ResponseEntity<String>("No such element found", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(chapterStat, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("No such element found", HttpStatus.OK);
		}
	}
	
	@GetMapping("resum/{sid}/{cid}")
	public ResponseEntity<?> getResume(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		ChapterStatPrimaryKey id = new ChapterStatPrimaryKey(sId, cId);
		try {
			ChapterStat chapterStat = service.getResume(sId,cId);
			if (chapterStat == null || chapterStat.getId() == null || chapterStat.getId().getChapterId() == null
					|| chapterStat.getId().getStudentId() == null) {
				return new ResponseEntity<String>("No such element found", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(chapterStat, HttpStatus.OK);
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
	public ResponseEntity<?> save(@RequestBody ChapterStat chapterStat) {
		return new ResponseEntity<>(service.save(chapterStat), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody ChapterStat chapterStat) {
		return new ResponseEntity<>(service.save(chapterStat), HttpStatus.OK);
	}

	@DeleteMapping("{sid}/{cid}")
	public ResponseEntity<?> delete(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		ChapterStatPrimaryKey id = new ChapterStatPrimaryKey(sId, cId);
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

}
