package com.jitendra.eduapp.domin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author jitendra sagoriya
 *
 */
@Entity
@Table(name="MCQANSWER")
public class McqAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7667530811414436036L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="OPTION_1",length=100, nullable=false)
	private String option1;
	
	@Column(name="OPTION_2",length=100,nullable=false)
	private String option2;
	
	@Column(name="OPTION_3",length=100,nullable=false)
	private String option3;
	
	@Column(name="OPTION_4",length=100,nullable=false)
	private String option4;
	
	@Column(name="ANSWER",length=100,nullable=false)
	private String answer;
	
	@Column(name="DESCRIPTION",length=500 ,nullable=false)
	private String discription;
	
	@Column(name="QID",nullable=false)
	private Long qId;

	public McqAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public McqAnswer(Long id, String option1, String option2, String option3, String option4, String answer,
			String discription, Long qId) {
		super();
		this.id = id;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.discription = discription;
		this.qId = qId;
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
	 * @return the option1
	 */
	public String getOption1() {
		return option1;
	}

	/**
	 * @param option1 the option1 to set
	 */
	public void setOption1(String option1) {
		this.option1 = option1;
	}

	/**
	 * @return the option2
	 */
	public String getOption2() {
		return option2;
	}

	/**
	 * @param option2 the option2 to set
	 */
	public void setOption2(String option2) {
		this.option2 = option2;
	}

	/**
	 * @return the option3
	 */
	public String getOption3() {
		return option3;
	}

	/**
	 * @param option3 the option3 to set
	 */
	public void setOption3(String option3) {
		this.option3 = option3;
	}

	/**
	 * @return the option4
	 */
	public String getOption4() {
		return option4;
	}

	/**
	 * @param option4 the option4 to set
	 */
	public void setOption4(String option4) {
		this.option4 = option4;
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
	 * @return the discription
	 */
	public String getDiscription() {
		return discription;
	}

	/**
	 * @param discription the discription to set
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	/**
	 * @return the qId
	 */
	public Long getqId() {
		return qId;
	}

	/**
	 * @param qId the qId to set
	 */
	public void setqId(Long qId) {
		this.qId = qId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((discription == null) ? 0 : discription.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((option1 == null) ? 0 : option1.hashCode());
		result = prime * result + ((option2 == null) ? 0 : option2.hashCode());
		result = prime * result + ((option3 == null) ? 0 : option3.hashCode());
		result = prime * result + ((option4 == null) ? 0 : option4.hashCode());
		result = prime * result + ((qId == null) ? 0 : qId.hashCode());
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
		McqAnswer other = (McqAnswer) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (discription == null) {
			if (other.discription != null)
				return false;
		} else if (!discription.equals(other.discription))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (option1 == null) {
			if (other.option1 != null)
				return false;
		} else if (!option1.equals(other.option1))
			return false;
		if (option2 == null) {
			if (other.option2 != null)
				return false;
		} else if (!option2.equals(other.option2))
			return false;
		if (option3 == null) {
			if (other.option3 != null)
				return false;
		} else if (!option3.equals(other.option3))
			return false;
		if (option4 == null) {
			if (other.option4 != null)
				return false;
		} else if (!option4.equals(other.option4))
			return false;
		if (qId == null) {
			if (other.qId != null)
				return false;
		} else if (!qId.equals(other.qId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "McqAnswer [id=" + id + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3
				+ ", option4=" + option4 + ", answer=" + answer + ", discription=" + discription + ", qId=" + qId + "]";
	}
	
	

}
