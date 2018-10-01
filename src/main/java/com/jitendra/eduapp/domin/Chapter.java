package com.jitendra.eduapp.domin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="CHAPTER")  
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
public class Chapter implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME",length=150,nullable=false,unique=true)
	@NotNull(message="name should not be null.")
	private String name;
	
	@Column(name="SUBJECT",length=50,nullable=false)
	@NotNull(message="Subject should not be null.")
	private String subject;
	
	@Column(name="CLASS",length=25,nullable=false)
	@NotNull(message="class should not be null.")
	private String classz; 
	
	
	public Chapter(Long id, String name,
			 String subject,
			 String classz ) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	 
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

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", subject=" + subject + ", classz=" + classz + "]";
	}

	 
	
}
