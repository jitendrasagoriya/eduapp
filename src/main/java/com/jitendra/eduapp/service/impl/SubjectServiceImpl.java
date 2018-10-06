package com.jitendra.eduapp.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jitendra.eduapp.constants.Constant;
import com.jitendra.eduapp.dao.SubjectDaoService;
import com.jitendra.eduapp.domin.Subject;
import com.jitendra.eduapp.service.SubjectService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * @author jitendra sagoriya
 *
 */
@Service
public class SubjectServiceImpl extends BaseService<Subject> implements SubjectService {
	
	public static Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);
	
	@Autowired
	private SubjectDaoService service;

	@Override
	public Page<Subject> getAll(Pageable pageable) {
		return service.getRepository().findAll(pageable);
	}

	@Override
	public List<Subject> getAll() {
		return service.getRepository().findAll();
	}

	@Override
	public Subject getById(Long id) {
		try {
			return  service.getRepository().findById(id).get();
		}catch (NoSuchElementException e) {
			logger.error("No such element found : id "+id);
			return  null;			
		}		
	}

	@Override
	public Subject getByName(Long id) {
		return null;
	}

	@Override
	public Subject save(Subject subject) {
		return service.getRepository().save(subject);
	}

	@Override
	public void delete(Long id) {
		service.getRepository().deleteById(id);	
	}

	@Override
	public Subject update(Subject subject) {
		return service.getRepository().saveAndFlush(subject);
	}

	@Override
	public StringBuffer downlaod() {
		List<Subject> subjects = getAll();
		StringBuffer stringBuffer = new StringBuffer();
		for (Subject subject : subjects) {
			stringBuffer.append(subject.getId());
			stringBuffer.append(Constant.COMMA_DELIMITER);
			stringBuffer.append(subject.getName());
			stringBuffer.append(Constant.NEW_LINE_SEPARATOR);
		}
		return stringBuffer;
	}
	
	
	@Override
	public List<Subject> uploadFile(MultipartFile multipartFile) throws IOException {

		File file = convertMultiPartToFile(multipartFile);

		List<Subject> mandatoryMissedList = new ArrayList<Subject>();

		try (Reader reader = new FileReader(file);) {
			@SuppressWarnings("unchecked")
			CsvToBean<Subject> csvToBean = new CsvToBeanBuilder<Subject>(reader).withType(Subject.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<Subject> studentList = csvToBean.parse();

			Iterator<Subject> subjectListClone = studentList.iterator();

			while (subjectListClone.hasNext()) {

				Subject student = subjectListClone.next();

				if (false) {
					mandatoryMissedList.add(student);
					subjectListClone.remove();
				}
			}

			service.batchStore(studentList);
		}
		return mandatoryMissedList;
	}

}
