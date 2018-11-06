package com.jitendra.eduapp.enums;

import java.util.HashMap;
import java.util.Map;

public enum Progress {
	
	 NOTSTART(12001,"NOTSTART","NOTSTART"),
	 INPROGRESS(12002,"INPROGRESS","INPROGRESS"),
	 COMPLETED(12003,"COMPLETED","COMPLETED") ;
	
	
	private static final Map<Integer, Progress> byId = new HashMap<Integer, Progress>();
	private static final Map<String, Progress> byValue = new HashMap<String, Progress>();
	
	
	static {
	     for (Progress e : Progress.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static Progress getById(int id) {
	    return byId.get(id);
	 }
	 
	public static Progress getByValue(String value) {
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
	private Progress(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, Progress> getByid() {
		return byId;
	}

	public static Map<String, Progress> getByvalue() {
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
