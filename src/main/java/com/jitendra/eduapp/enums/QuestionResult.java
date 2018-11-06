package com.jitendra.eduapp.enums;

import java.util.HashMap;
import java.util.Map;

public enum QuestionResult {
	
	
	 CORRECT(12001,"CORRECT","CORRECT"),
	 INCORRECT(12002,"INCORRECT","INCORRECT")  ;
	
	
	private static final Map<Integer, QuestionResult> byId = new HashMap<Integer, QuestionResult>();
	private static final Map<String, QuestionResult> byValue = new HashMap<String, QuestionResult>();
	
	
	static {
	     for (QuestionResult e : QuestionResult.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static QuestionResult getById(int id) {
	    return byId.get(id);
	 }
	 
	public static QuestionResult getByValue(String value) {
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
	private QuestionResult(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, QuestionResult> getByid() {
		return byId;
	}

	public static Map<String, QuestionResult> getByvalue() {
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
