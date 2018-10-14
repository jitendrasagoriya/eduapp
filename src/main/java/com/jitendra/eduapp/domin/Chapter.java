package com.jitendra.eduapp.domin;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jitendra.eduapp.constants.Constant;

/**
 * @author jitendra sagoriya
 *
 */
@Entity
@Table(name = "CHAPTER", uniqueConstraints = @UniqueConstraint(columnNames = { "NAME", "SUBJECT", "CLASS" }))
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Chapter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", length = 150, nullable = false)
	@NotNull(message = "name should not be null.")
	private String name;

	@Column(name = "SUBJECT", length = 50, nullable = false)
	@NotNull(message = "Subject should not be null.")
	private String subject;

	@Column(name = "CLASS", length = 25, nullable = false)
	@NotNull(message = "class should not be null.")
	private String classz;
	
	@Column(name = "VIDEOCOUNT")
	private Integer videoCount;
	
	@Column(name = "QUESTIONCOUNT")
	private Integer questionCount;
	
	@Column(name = "CONCEPTCOUNT")
	private Integer conceptCount;
	
	@Column(name = "SEQUENCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chapter_generator")
	@SequenceGenerator(name="chapter_generator", sequenceName = "chapter_seq", allocationSize=50)
	private Integer sequence;
	
	@Column(name="RESUME",nullable = true)
	private Boolean resume;
	
	@Column(name="RESUMETIME",nullable = true)
	private Timestamp resumeTimestamp;
	

	public Chapter(Long id, String name, String subject, String classz) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.classz = classz;

	}

	public Chapter() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getClassz() {
		return classz;
	}

	public void setClassz(String classz) {
		this.classz = classz;
	}
	
	

	/**
	 * @return the videoCount
	 */
	public Integer getVideoCount() {
		return videoCount;
	}

	/**
	 * @param videoCount the videoCount to set
	 */
	public void setVideoCount(Integer videoCount) {
		this.videoCount = videoCount;
	}

	/**
	 * @return the questionCount
	 */
	public Integer getQuestionCount() {
		return questionCount;
	}

	/**
	 * @param questionCount the questionCount to set
	 */
	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	/**
	 * @return the conceptCount
	 */
	public Integer getConceptCount() {
		return conceptCount;
	}

	/**
	 * @param conceptCount the conceptCount to set
	 */
	public void setConceptCount(Integer conceptCount) {
		this.conceptCount = conceptCount;
	}

	/**
	 * @return the sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the resume
	 */
	public boolean isResume() {
		return resume;
	}

	/**
	 * @param resume the resume to set
	 */
	public void setResume(Boolean resume) {
		this.resume = resume;
	}

	/**
	 * @return the resumeTimestamp
	 */
	public Timestamp getResumeTimestamp() {
		return resumeTimestamp;
	}

	/**
	 * @param resumeTimestamp the resumeTimestamp to set
	 */
	public void setResumeTimestamp(Timestamp resumeTimestamp) {
		this.resumeTimestamp = resumeTimestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classz == null) ? 0 : classz.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapter other = (Chapter) obj;
		if (classz == null) {
			if (other.classz != null)
				return false;
		} else if (!classz.equals(other.classz))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", subject=" + subject + ", classz=" + classz + ", videoCount="
				+ videoCount + ", questionCount=" + questionCount + ", conceptCount=" + conceptCount + ", sequence="
				+ sequence + ", resume=" + resume + "]";
	}

	public String toCSVString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(this.getId());
		buffer.append(Constant.COMMA_DELIMITER);

		buffer.append(this.getName());
		buffer.append(Constant.COMMA_DELIMITER);

		buffer.append(this.getSubject());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getVideoCount());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getQuestionCount());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getConceptCount());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getSequence());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.isResume());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getResumeTimestamp());
		buffer.append(Constant.COMMA_DELIMITER);

		buffer.append(this.getClassz());
		buffer.append(Constant.NEW_LINE_SEPARATOR);

		return buffer.toString();
	}

}
