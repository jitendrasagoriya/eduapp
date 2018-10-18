package com.jitendra.eduapp.domin;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jitendra.eduapp.domin.key.VideoStatPrimaryKey;
import com.jitendra.eduapp.enums.Progress;

@Entity
@Table(name = "VIDEOSTAT")
public class VideoStat implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VideoStatPrimaryKey id;

	@Column(name="LASTWATCHED")
	private Timestamp lastWatched;

	@Column(name="COMPLETED")
	private Boolean completed;

	@Column(name="PROGRESS")
	private Progress progress;

	public VideoStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoStat(VideoStatPrimaryKey id, Timestamp lastWatched, Boolean completed, Progress progress) {
		super();
		this.id = id;
		this.lastWatched = lastWatched;
		this.completed = completed;
		this.progress = progress;
	}

	/**
	 * @return the id
	 */
	public VideoStatPrimaryKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VideoStatPrimaryKey id) {
		this.id = id;
	}

	/**
	 * @return the lastWatched
	 */
	public Timestamp getLastWatched() {
		return lastWatched;
	}

	/**
	 * @param lastWatched the lastWatched to set
	 */
	public void setLastWatched(Timestamp lastWatched) {
		this.lastWatched = lastWatched;
	}

	/**
	 * @return the completed
	 */
	public Boolean getCompleted() {
		return completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(Boolean completed) {
		this.completed = completed;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completed == null) ? 0 : completed.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastWatched == null) ? 0 : lastWatched.hashCode());
		result = prime * result + ((progress == null) ? 0 : progress.hashCode());
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
		VideoStat other = (VideoStat) obj;
		if (completed == null) {
			if (other.completed != null)
				return false;
		} else if (!completed.equals(other.completed))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastWatched == null) {
			if (other.lastWatched != null)
				return false;
		} else if (!lastWatched.equals(other.lastWatched))
			return false;
		if (progress != other.progress)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " {id:" + id + ", lastWatched:" + lastWatched + ", completed:" + completed + ", progress:"
				+ progress + "}";
	}
	
	

}
