package com.jitendra.eduapp.endpoint;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.eduapp.builder.AuthenticationBuilder;
import com.jitendra.eduapp.builder.StudentBuilder;
import com.jitendra.eduapp.domin.Authentication;
import com.jitendra.eduapp.domin.Student;
import com.jitendra.eduapp.dto.AuthenticationDto;
import com.jitendra.eduapp.dto.StudentDto;
import com.jitendra.eduapp.service.AuthenticationService;
import com.jitendra.eduapp.service.StudentService;
import com.jitendra.eduapp.utils.CommonUtils;
import com.jitendra.eduapp.validator.CommonValidator;

@RestController
@RequestMapping(path = "/api/student/", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE })
public class StudentEndpoint {

	@Value("${authenticate.salt}")
	private String salt;

	@Autowired
	private StudentService studentService;

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping({ "id" })
	public ResponseEntity<?> get(@PathVariable Long id) {
		return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable) {
		return new ResponseEntity<>(studentService.getAll(pageable), HttpStatus.OK);
	}

	@PostMapping(path = "add/", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.save(student), HttpStatus.OK);

	}

	@SuppressWarnings("deprecation")
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {

		if (!NumberUtils.isNumber(studentDto.getPhoneNumber())) {
			return new ResponseEntity<String>("Phone number is not vaild", HttpStatus.PARTIAL_CONTENT);
		}

		if (CommonUtils.isValidEmail(studentDto.getEmail())) {
			return new ResponseEntity<String>("Email is not vaild", HttpStatus.PARTIAL_CONTENT);
		}

		if (studentService.checkEmail(studentDto.getEmail())) {
			return new ResponseEntity<String>("Email is already register. Please try with some other email",
					HttpStatus.PARTIAL_CONTENT);
		}

		if (studentService.checkNickname(studentDto.getNickName())) {
			return new ResponseEntity<String>("Nickname is already present. Please try with some other nickname",
					HttpStatus.PARTIAL_CONTENT);
		}

		Student student = new StudentBuilder(studentDto).build();

		Authentication authentication = new AuthenticationBuilder(studentDto, salt).build();

		CommonValidator<Student> commonValidator = new CommonValidator<>();
		Set<ConstraintViolation<Student>> violations = commonValidator.validate(student);

		if (!violations.isEmpty()) {
			return new ResponseEntity<>(violations, HttpStatus.PARTIAL_CONTENT);
		}

		try {
			student = studentService.save(student);
			if (student.getId() != null) {
				authentication.setstudentId(student.getId());
				authenticationService.save(authentication);
			}

			AuthenticationDto authenticationDto = new AuthenticationDto(student.getName(),
					authentication.getAccessToken(), authentication.getTokenTimeout());

			return new ResponseEntity<AuthenticationDto>(authenticationDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> modifyStudent(@RequestBody @Valid Student student) {
		return new ResponseEntity<Student>(studentService.save(student), HttpStatus.OK);

	}

	@DeleteMapping({ "id" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			studentService.delete( id);
			return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
