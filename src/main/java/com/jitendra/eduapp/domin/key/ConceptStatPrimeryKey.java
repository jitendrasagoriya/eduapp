package com.jitendra.eduapp.domin.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ConceptStatPrimeryKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "SID")
	private Long studentId;

	@Column(name = "CID")
	private Long conceptId;

	public ConceptStatPrimeryKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConceptStatPrimeryKey(Long studentId, Long conceptId) {
		super();
		this.studentId = studentId;
		this.conceptId = conceptId;
	}

	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the conceptId
	 */
	public Long getconceptId() {
		return conceptId;
	}

	/**
	 * @param conceptId the conceptId to set
	 */
	public void setconceptId(Long conceptId) {
		this.conceptId = conceptId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conceptId == null) ? 0 : conceptId.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConceptStatPrimeryKey other = (ConceptStatPrimeryKey) obj;
		if (conceptId == null) {
			if (other.conceptId != null)
				return false;
		} else if (!conceptId.equals(other.conceptId))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " {studentId:" + studentId + ", conceptId:" + conceptId + "}";
	}
	
	


}
