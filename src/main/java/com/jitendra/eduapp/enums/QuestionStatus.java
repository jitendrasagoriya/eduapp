package com.jitendra.eduapp.enums;

import java.util.HashMap;
import java.util.Map;


/**
 * @author jitendra sagoriya
 *
 */
public enum QuestionStatus {
	
	 STATUS1(80001,"TYPE1","TYPE1"),
	 STATUS2(80002,"TYPE2","TYPE2"),
	 STATUS3(80003,"TYPE3","TYPE3"),
	 STATUS4(80004,"TYPE4","TYPE4");
	
	
	private static final Map<Integer, QuestionStatus> byId = new HashMap<Integer, QuestionStatus>();
	private static final Map<String, QuestionStatus> byValue = new HashMap<String, QuestionStatus>();
	
	
	static {
	     for (QuestionStatus e : QuestionStatus.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static QuestionStatus getById(int id) {
	    return byId.get(id);
	 }
	 
	public static QuestionStatus getByValue(String value) {
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
	private QuestionStatus(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, QuestionStatus> getByid() {
		return byId;
	}

	public static Map<String, QuestionStatus> getByvalue() {
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
