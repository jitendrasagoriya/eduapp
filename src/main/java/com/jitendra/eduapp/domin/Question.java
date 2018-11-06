package com.jitendra.eduapp.domin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jitendra.eduapp.constants.Constant;
import com.jitendra.eduapp.enums.Difficuly;
import com.jitendra.eduapp.enums.QuestionStatus;
import com.jitendra.eduapp.enums.QuestionType;
/**
 * @author jitendra sagoriya
 *
 */


/**
 * 	{
 * 		"question":"",
 * 		"answer":"",
 * 		"type":"",
 * 		"status":"",
 * 		"difficuly":"",
 * 		"chapterId":""
 * 
 * 	}
 * */
@Entity
@Table(name="QUESTION") 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Question implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="QUESTION",length=500,nullable=false,unique=true)
	@NotNull(message="question should not be null.")
	private String question;
	
	@Column(name="ANSWER",nullable=false )
	private String answer; 
	
	@Column(name="TYPE",nullable=false )
	@NotNull(message="Please provide type of question")
	private QuestionType type;
	
	@Column(name="IMG",nullable=true )
	private String img;
	
	@Column(name="LINK",nullable=true )
	private String link;
	
	@Column(name="VIDEOLINK",nullable=true )
	private String videoLink;
	
	@Column(name="STATUS",nullable=false )
	@NotNull(message="Please provide status  of question")
	private QuestionStatus status;
	
	@Column(name="DIFFICULT",nullable=false )	
	@NotNull(message="Please provide difficuly level of question") 
	private Difficuly difficuly;
	
	@Column
	@NotNull(message="chapterId should not be null.")
	private Long chapterId;
	
	@Transient
	private McqAnswer mcqAnswer;
	
	@Column(name = "SEQUENCE") 
	private Integer sequence;
	
	
	

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Question(QuestionType type,
			  QuestionStatus status,
			 Difficuly difficuly,
			 Long chapterId, Integer sequence) {
		super();
		this.type = type;
		this.status = status;
		this.difficuly = difficuly;
		this.chapterId = chapterId;
		this.sequence = sequence;
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
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
	 * @return the type
	 */
	public QuestionType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(QuestionType type) {
		this.type = type;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the videoLink
	 */
	public String getVideoLink() {
		return videoLink;
	}

	/**
	 * @param videoLink the videoLink to set
	 */
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	/**
	 * @return the status
	 */
	public QuestionStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(QuestionStatus status) {
		this.status = status;
	}

	/**
	 * @return the difficuly
	 */
	public Difficuly getDifficuly() {
		return difficuly;
	}

	/**
	 * @param difficuly the difficuly to set
	 */
	public void setDifficuly(Difficuly difficuly) {
		this.difficuly = difficuly;
	}
	
	

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}
	
	

	/**
	 * @return the mcqAnswer
	 */
	public McqAnswer getMcqAnswer() {
		return mcqAnswer;
	}

	/**
	 * @param mcqAnswer the mcqAnswer to set
	 */
	public void setMcqAnswer(McqAnswer mcqAnswer) {
		this.mcqAnswer = mcqAnswer;
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
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((chapterId == null) ? 0 : chapterId.hashCode());
		result = prime * result + ((difficuly == null) ? 0 : difficuly.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((videoLink == null) ? 0 : videoLink.hashCode());
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
		Question other = (Question) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (chapterId == null) {
			if (other.chapterId != null)
				return false;
		} else if (!chapterId.equals(other.chapterId))
			return false;
		if (difficuly != other.difficuly)
			return false;
		if (id != other.id)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		if (videoLink == null) {
			if (other.videoLink != null)
				return false;
		} else if (!videoLink.equals(other.videoLink))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + ", type=" + type + ", img="
				+ img + ", link=" + link + ", videoLink=" + videoLink + ", status=" + status + ", difficuly="
				+ difficuly + ", chapterId=" + chapterId + ", mcqAnswer=" + mcqAnswer + "]";
	}
	
	public String toCsvString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getId());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getQuestion());
		buffer.append(Constant.COMMA_DELIMITER);		
		
		buffer.append(this.getType());
		buffer.append(Constant.COMMA_DELIMITER);		
		
		buffer.append(this.getImg());
		buffer.append(Constant.COMMA_DELIMITER);		
		
		buffer.append(this.getAnswer());
		buffer.append(Constant.COMMA_DELIMITER);		
		
		buffer.append(this.getLink());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getVideoLink());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getStatus());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getStatus());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getSequence());
		buffer.append(Constant.COMMA_DELIMITER);
		
		buffer.append(this.getChapterId());
		buffer.append(Constant.NEW_LINE_SEPARATOR);

		return buffer.toString();
	}

}
