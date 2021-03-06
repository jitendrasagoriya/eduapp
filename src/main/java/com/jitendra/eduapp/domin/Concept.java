package com.jitendra.eduapp.domin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.jitendra.eduapp.constants.Constant;
import com.jitendra.eduapp.enums.ConceptType;

/**
 * @author jitendra sagoriya
 *
 */
@Entity
@Table(name="CONCEPT")
public class Concept implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME",length=25,nullable=false,unique=true)
	@NotNull(message="Subject should not be null.")
	private String name;
	
	@Column(name="DEFINATION",length=25,nullable=false,unique=true)
	@NotNull(message="Defination should not be null.")
	private String defination;
	
	@Column(name="TYPE",length=25,nullable=false)
	private ConceptType type;
	
	@Column
	@NotNull(message="chapterId should not be null.")
	private Long chapterId;
	
	@Column(name = "SEQUENCE") 
	private Integer sequence;
	

	public Concept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Concept(Long id,  String name, ConceptType type,
			 Long chapterId) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.chapterId = chapterId;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the defination
	 */
	public String getDefination() {
		return defination;
	}

	/**
	 * @param defination the defination to set
	 */
	public void setDefination(String defination) {
		this.defination = defination;
	}

	/**
	 * @return the type
	 */
	public ConceptType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ConceptType type) {
		this.type = type;
	}

	
	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chapterId == null) ? 0 : chapterId.hashCode());
		result = prime * result + ((defination == null) ? 0 : defination.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Concept other = (Concept) obj;
		if (chapterId == null) {
			if (other.chapterId != null)
				return false;
		} else if (!chapterId.equals(other.chapterId))
			return false;
		if (defination == null) {
			if (other.defination != null)
				return false;
		} else if (!defination.equals(other.defination))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concept [id=" + id + ", name=" + name + ", defination=" + defination + ", type=" + type + ", chapterId="
				+ chapterId + ", sequence=" + sequence + "]";
	}
	
	
	public String toCSVString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(this.getId());
		buffer.append(Constant.COMMA_DELIMITER);

		buffer.append(this.getName());
		buffer.append(Constant.COMMA_DELIMITER);

		buffer.append(this.getDefination());
		buffer.append(Constant.COMMA_DELIMITER);

		buffer.append(this.getType());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getSequence());
		buffer.append(Constant.COMMA_DELIMITER);

		buffer.append(this.getChapterId());
		buffer.append(Constant.NEW_LINE_SEPARATOR);

		return buffer.toString();
	}
	

}
