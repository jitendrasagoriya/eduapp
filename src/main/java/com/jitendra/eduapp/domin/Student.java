package com.jitendra.eduapp.domin;

 
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	@NotNull
	private String Name;

	@Column(name = "NICKNAME", unique = true, length = 20)
	private String nickName;

	@Column(name = "EMAIL", unique = true)
	@NotNull
	@Email(message = "Email is not valid")
	private String email;

	@Column(name = "PHONE")
	@NotNull
	@Size(min = 10, max = 10, message = "Mobile number should be 10 digits.")
	private String phoneNumber;

	@Column(name = "CLASS")
	private String classz;

	@Column(name = "BOARD")
	private String board;

	@Column(name = "SUBJECT")
	private  String subject;

	@Column(name = "LANGUAGE")
	private String language;

	@Column(name = "JOININGDATE")
	private Timestamp joingDate;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, @NotNull String name, String nickName,
			@NotNull @Email(message = "Email is not valid") String email,
			@NotNull @Size(min = 10, max = 10, message = "Mobile number should be 10 digits.") String phoneNumber,
			String classz, String board, String subject, String language, Timestamp joingDate) {
		super();
		this.id = id;
		Name = name;
		this.nickName = nickName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.classz = classz;
		this.board = board;
		this.subject = subject;
		this.language = language;
		this.joingDate = joingDate;
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
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the classz
	 */
	public String getClassz() {
		return classz;
	}

	/**
	 * @param classz the classz to set
	 */
	public void setClassz(String classz) {
		this.classz = classz;
	}

	/**
	 * @return the board
	 */
	public String getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(String board) {
		this.board = board;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the joingDate
	 */
	public Timestamp getJoingDate() {
		return joingDate;
	}

	/**
	 * @param joingDate the joingDate to set
	 */
	public void setJoingDate(Timestamp joingDate) {
		this.joingDate = joingDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		result = prime * result + ((classz == null) ? 0 : classz.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joingDate == null) ? 0 : joingDate.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Student other = (Student) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		if (classz == null) {
			if (other.classz != null)
				return false;
		} else if (!classz.equals(other.classz))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (joingDate == null) {
			if (other.joingDate != null)
				return false;
		} else if (!joingDate.equals(other.joingDate))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
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
		return "{id:" + id + ", Name:" + Name + ", nickName:" + nickName + ", email:" + email + ", phoneNumber:"
				+ phoneNumber + ", classz:" + classz + ", board:" + board + ", subject:" + subject + ", language:"
				+ language + ", joingDate:" + joingDate + "}";
	}
	
	
	
}
