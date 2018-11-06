package com.jitendra.eduapp.domin;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jitendra.eduapp.domin.key.QuestionStatPromeryKey;
import com.jitendra.eduapp.enums.Progress;
import com.jitendra.eduapp.enums.QuestionResult;

@Entity
@Table(name = "QUESTIONSTAT")
public class QuestionStat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private QuestionStatPromeryKey id;
	
	@Column(name="PROGRESS")
	private Progress progress; 
	
	@Column(name="RESULT")
	private QuestionResult result;
	
	@Column(name="ANSWER")
	private String answer;	
	
	@Column(name="LASTMODIFYTIME")
	private Timestamp lastModifyTime;

	public QuestionStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionStat(QuestionStatPromeryKey id, Progress progress, QuestionResult result, String answer,
			Timestamp lastModifyTime) {
		super();
		this.id = id;
		this.progress = progress;
		this.result = result;
		this.answer = answer;
		this.lastModifyTime = lastModifyTime;
	}

	/**
	 * @return the id
	 */
	public QuestionStatPromeryKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(QuestionStatPromeryKey id) {
		this.id = id;
	}

	/**
	 * @return the progress
	 */
	public Progress getProgress() {
		return progress;
	}

	/**
	 * @param progress the progress to set
	 */
	public void setProgress(Progress progress) {
		this.progress = progress;
	}

	/**
	 * @return the result
	 */
	public QuestionResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(QuestionResult result) {
		this.result = result;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the lastModifyTime
	 */
	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	/**
	 * @param lastModifyTime the lastModifyTime to set
	 */
	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastModifyTime == null) ? 0 : lastModifyTime.hashCode());
		result = prime * result + ((progress == null) ? 0 : progress.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
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
		QuestionStat other = (QuestionStat) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastModifyTime == null) {
			if (other.lastModifyTime != null)
				return false;
		} else if (!lastModifyTime.equals(other.lastModifyTime))
			return false;
		if (progress != other.progress)
			return false;
		if (result != other.result)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{id:" + id + ", progress:" + progress + ", result:" + result + ", answer:" + answer
				+ ", lastModifyTime:" + lastModifyTime + "}";
	}
	
	
	

}
