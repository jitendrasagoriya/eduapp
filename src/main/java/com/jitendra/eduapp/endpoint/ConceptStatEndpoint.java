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

import com.jitendra.eduapp.domin.ConceptStat;
import com.jitendra.eduapp.domin.key.ConceptStatPrimeryKey;
import com.jitendra.eduapp.service.ConceptStatService;

/**
 * @author jitendra sagoriya
 *
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/api/concept/stat/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ConceptStatEndpoint {
	
	

	@Autowired
	private ConceptStatService service;

	@GetMapping("{sid}/{cid}")
	public ResponseEntity<?> get(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		ConceptStatPrimeryKey id = new ConceptStatPrimeryKey(sId, cId);
		try {
			ConceptStat conceptStat  = service.getById(id);
			if (conceptStat == null || conceptStat.getId() == null || conceptStat.getId().getconceptId() == null
					|| conceptStat.getId().getStudentId() == null) {
				return new ResponseEntity<String>("No such element found", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(conceptStat, HttpStatus.OK);
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
	public ResponseEntity<?> save(@RequestBody ConceptStat chapterStat) {
		return new ResponseEntity<>(service.save(chapterStat), HttpStatus.OK);
	} 

	@DeleteMapping("{sid}/{cid}")
	public ResponseEntity<?> delete(@PathVariable("sid") Long sId, @PathVariable("cid") Long cId) {
		ConceptStatPrimeryKey id = new ConceptStatPrimeryKey(sId, cId);
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

}
