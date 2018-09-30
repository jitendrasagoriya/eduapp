package com.jitendra.eduapp.enums;

import java.util.HashMap;
import java.util.Map;

public enum Difficuly {
	
	 EASY(90001,"EASY","EASY"),
	 MEDIUM(90002,"MEDIUM","MEDIUM"),
	 HARD(90003,"HARD","HARD") ;
	
	
	private static final Map<Integer, Difficuly> byId = new HashMap<Integer, Difficuly>();
	private static final Map<String, Difficuly> byValue = new HashMap<String, Difficuly>();
	
	
	static {
	     for (Difficuly e : Difficuly.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static Difficuly getById(int id) {
	    return byId.get(id);
	 }
	 
	public static Difficuly getByValue(String value) {
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
	private Difficuly(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, Difficuly> getByid() {
		return byId;
	}

	public static Map<String, Difficuly> getByvalue() {
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
