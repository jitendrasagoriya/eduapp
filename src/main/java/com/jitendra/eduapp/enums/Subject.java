package com.jitendra.eduapp.enums;

import java.util.HashMap;
import java.util.Map;

public enum Subject {
	
	
	CHEMISTRY(10001,"CHEMISTRY","CHEMISTRY"),
	MATHS(10002,"MATHS","MATHS"),
	PHYSICS(10003,"PHYSICS","PHYSICS"),
	BIOLOGY(10004,"BIOLOGY","BIOLOGY");
	
	
	private static final Map<Integer, Subject> byId = new HashMap<Integer, Subject>();
	private static final Map<String, Subject> byValue = new HashMap<String, Subject>();
	
	
	static {
	     for (Subject e : Subject.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static Subject getById(int id) {
	    return byId.get(id);
	 }
	 
	public static Subject getByValue(String value) {
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
	private Subject(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, Subject> getByid() {
		return byId;
	}

	public static Map<String, Subject> getByvalue() {
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
