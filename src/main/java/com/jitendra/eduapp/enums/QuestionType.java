package com.jitendra.eduapp.enums;

import java.util.HashMap;
import java.util.Map;


/**
 * @author jitendra sagoriya
 *
 */
public enum QuestionType {
	
	 MCQ(70001,"MCQ","MCQ"),
	 LONGANSWER(70002,"LONGANSWER","LONGANSWER"),
	 ONELINER(70003,"ONELINER","ONELINER"),
	 TRUEFALSE(70004,"TRUEFALSE","TRUEFALSE");
	
	
	private static final Map<Integer, QuestionType> byId = new HashMap<Integer, QuestionType>();
	private static final Map<String, QuestionType> byValue = new HashMap<String, QuestionType>();
	
	
	static {
	     for (QuestionType e : QuestionType.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static QuestionType getById(int id) {
	    return byId.get(id);
	 }
	 
	public static QuestionType getByValue(String value) {
		    return byValue.get(value);
	}
	
	
	private Integer id;
	
	private String value;
	
	private String desc;

	/**
	 * @param id
	 * @param name
	 * @param desc
	 */
	private QuestionType(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, QuestionType> getByid() {
		return byId;
	}

	public static Map<String, QuestionType> getByvalue() {
		return byValue;
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}


}
