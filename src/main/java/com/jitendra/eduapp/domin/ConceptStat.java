package com.jitendra.eduapp.domin;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jitendra.eduapp.domin.key.ConceptStatPrimeryKey;

@Entity
@Table(name = "CONCEPTSTAT")
public class ConceptStat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ConceptStatPrimeryKey id;
	
	@Column(name="LASTATTEMPTED")
	private Timestamp lastAttempted;

	@Column(name=" ATTEMPTED")
	private Boolean Attempted;

	public ConceptStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConceptStat(ConceptStatPrimeryKey id, Timestamp lastAttempted, Boolean attempted) {
		super();
		this.id = id;
		this.lastAttempted = lastAttempted;
		Attempted = attempted;
	}
	
	

	/**
	 * @return the id
	 */
	public ConceptStatPrimeryKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ConceptStatPrimeryKey id) {
		this.id = id;
	}

	/**
	 * @return the lastAttempted
	 */
	public Timestamp getLastAttempted() {
		return lastAttempted;
	}

	/**
	 * @param lastAttempted the lastAttempted to set
	 */
	public void setLastAttempted(Timestamp lastAttempted) {
		this.lastAttempted = lastAttempted;
	}

	/**
	 * @return the attempted
	 */
	public Boolean getAttempted() {
		return Attempted;
	}

	/**
	 * @param attempted the attempted to set
	 */
	public void setAttempted(Boolean attempted) {
		Attempted = attempted;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Attempted == null) ? 0 : Attempted.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastAttempted == null) ? 0 : lastAttempted.hashCode());
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
		ConceptStat other = (ConceptStat) obj;
		if (Attempted == null) {
			if (other.Attempted != null)
				return false;
		} else if (!Attempted.equals(other.Attempted))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastAttempted == null) {
			if (other.lastAttempted != null)
				return false;
		} else if (!lastAttempted.equals(other.lastAttempted))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConceptStat [id=" + id + ", lastAttempted=" + lastAttempted + ", Attempted=" + Attempted + "]";
	}
	
	
	

}
