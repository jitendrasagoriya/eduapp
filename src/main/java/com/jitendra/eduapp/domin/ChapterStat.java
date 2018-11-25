package com.jitendra.eduapp.domin;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jitendra.eduapp.domin.key.ChapterStatPrimaryKey;


@Entity
@Table(name="CHAPTERSTAT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChapterStat implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChapterStatPrimaryKey id;	
	
	@Column(name="MODIFYDATE",nullable=true)
	private Timestamp modifyDate;
	
	@Column(name="PERSANTAGE",nullable=true)
	private Integer completePersantage;
	
	@Column(name="RESUME",nullable=true)
	private Boolean resume;
	
	@Column(name="QATTEMPT",nullable=true)
	private Integer qAttempt;
	
	@Column(name="QINCORRECT",nullable=true)
	private Integer qIncorrect;
	
	@Column(name="QCORRECT",nullable=true)
	private Integer qCorrect;
	
	
	@Column(name="VWATCHED",nullable=true)
	private Integer vWatched;
	
	@Column(name="CKNOWN",nullable=true)
	private Integer cKnown;
	
	@Column(name="TIMETAKEN",nullable=true)
	private Integer timeTaken;
	
	
	@Column(name="SUBJECTID",nullable=true)
	private Long subjectId;

	public ChapterStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChapterStat(ChapterStatPrimaryKey id, Timestamp modifyDate, Integer completePersantage) {
		super();
		this.id = id;
		this.modifyDate = modifyDate;
		this.completePersantage = completePersantage;
	}

	public ChapterStat(ChapterStatPrimaryKey id, Timestamp modifyDate, Integer completePersantage, Boolean resume) {
		super();
		this.id = id;
		this.modifyDate = modifyDate;
		this.completePersantage = completePersantage;
		this.resume = resume;
	}
	
	

	public ChapterStat(ChapterStatPrimaryKey id, Timestamp modifyDate, Integer completePersantage, Boolean resume,
			Integer qAttempt, Integer qIncorrect, Integer qCorrect, Integer vWatched, Integer cKnown,
			Integer timeTaken) {
		super();
		this.id = id;
		this.modifyDate = modifyDate;
		this.completePersantage = completePersantage;
		this.resume = resume;
		this.qAttempt = qAttempt;
		this.qIncorrect = qIncorrect;
		this.qCorrect = qCorrect;
		this.vWatched = vWatched;
		this.cKnown = cKnown;
		this.timeTaken = timeTaken;
	}

	/**
	 * @return the id
	 */
	public ChapterStatPrimaryKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ChapterStatPrimaryKey id) {
		this.id = id;
	}

	/**
	 * @return the modifyDate
	 */
	public Timestamp getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return the completePersantage
	 */
	public Integer getCompletePersantage() {
		return completePersantage;
	}

	/**
	 * @param completePersantage the completePersantage to set
	 */
	public void setCompletePersantage(Integer completePersantage) {
		this.completePersantage = completePersantage;
	}

	/**
	 * @return the resume
	 */
	public Boolean getResume() {
		return resume;
	}

	/**
	 * @param resume the resume to set
	 */
	public void setResume(Boolean resume) {
		this.resume = resume;
	}
	
	

	/**
	 * @return the qAttempt
	 */
	public Integer getqAttempt() {
		return qAttempt;
	}

	/**
	 * @param qAttempt the qAttempt to set
	 */
	public void setqAttempt(Integer qAttempt) {
		this.qAttempt = qAttempt;
	}

	/**
	 * @return the qIncorrect
	 */
	public Integer getqIncorrect() {
		return qIncorrect;
	}

	/**
	 * @param qIncorrect the qIncorrect to set
	 */
	public void setqIncorrect(Integer qIncorrect) {
		this.qIncorrect = qIncorrect;
	}

	/**
	 * @return the qCorrect
	 */
	public Integer getqCorrect() {
		return qCorrect;
	}

	/**
	 * @param qCorrect the qCorrect to set
	 */
	public void setqCorrect(Integer qCorrect) {
		this.qCorrect = qCorrect;
	}

	/**
	 * @return the vWatched
	 */
	public Integer getvWatched() {
		return vWatched;
	}

	/**
	 * @param vWatched the vWatched to set
	 */
	public void setvWatched(Integer vWatched) {
		this.vWatched = vWatched;
	}

	/**
	 * @return the cKnown
	 */
	public Integer getcKnown() {
		return cKnown;
	}

	/**
	 * @param cKnown the cKnown to set
	 */
	public void setcKnown(Integer cKnown) {
		this.cKnown = cKnown;
	}

	/**
	 * @return the timeTaken
	 */
	public Integer getTimeTaken() {
		return timeTaken;
	}

	/**
	 * @param timeTaken the timeTaken to set
	 */
	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}
	
	

	/**
	 * @return the subjectId
	 */
	public Long getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cKnown == null) ? 0 : cKnown.hashCode());
		result = prime * result + ((completePersantage == null) ? 0 : completePersantage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((qAttempt == null) ? 0 : qAttempt.hashCode());
		result = prime * result + ((qCorrect == null) ? 0 : qCorrect.hashCode());
		result = prime * result + ((qIncorrect == null) ? 0 : qIncorrect.hashCode());
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		result = prime * result + ((subjectId == null) ? 0 : subjectId.hashCode());
		result = prime * result + ((timeTaken == null) ? 0 : timeTaken.hashCode());
		result = prime * result + ((vWatched == null) ? 0 : vWatched.hashCode());
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
		ChapterStat other = (ChapterStat) obj;
		if (cKnown == null) {
			if (other.cKnown != null)
				return false;
		} else if (!cKnown.equals(other.cKnown))
			return false;
		if (completePersantage == null) {
			if (other.completePersantage != null)
				return false;
		} else if (!completePersantage.equals(other.completePersantage))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modifyDate == null) {
			if (other.modifyDate != null)
				return false;
		} else if (!modifyDate.equals(other.modifyDate))
			return false;
		if (qAttempt == null) {
			if (other.qAttempt != null)
				return false;
		} else if (!qAttempt.equals(other.qAttempt))
			return false;
		if (qCorrect == null) {
			if (other.qCorrect != null)
				return false;
		} else if (!qCorrect.equals(other.qCorrect))
			return false;
		if (qIncorrect == null) {
			if (other.qIncorrect != null)
				return false;
		} else if (!qIncorrect.equals(other.qIncorrect))
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		if (subjectId == null) {
			if (other.subjectId != null)
				return false;
		} else if (!subjectId.equals(other.subjectId))
			return false;
		if (timeTaken == null) {
			if (other.timeTaken != null)
				return false;
		} else if (!timeTaken.equals(other.timeTaken))
			return false;
		if (vWatched == null) {
			if (other.vWatched != null)
				return false;
		} else if (!vWatched.equals(other.vWatched))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChapterStat [id=" + id + ", modifyDate=" + modifyDate + ", completePersantage=" + completePersantage
				+ ", resume=" + resume + ", qAttempt=" + qAttempt + ", qIncorrect=" + qIncorrect + ", qCorrect="
				+ qCorrect + ", vWatched=" + vWatched + ", cKnown=" + cKnown + ", timeTaken=" + timeTaken
				+ ", subjectId=" + subjectId + "]";
	}
	
	
	
	
	
}
