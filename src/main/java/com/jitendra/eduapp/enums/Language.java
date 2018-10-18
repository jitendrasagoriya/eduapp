package com.jitendra.eduapp.enums;

import java.util.HashMap;
import java.util.Map;

public enum Language {
	
	
	 HINDI(11001,"HINDI","HINDI"),
	 ENGLISH(11002,"ENGLISH","ENGLISH"),
	 MARATHI(11003,"MARATHI","MARATHI") ;
	
	
	private static final Map<Integer, Language> byId = new HashMap<Integer, Language>();
	private static final Map<String, Language> byValue = new HashMap<String, Language>();
	
	
	static {
	     for (Language e : Language.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static Language getById(int id) {
	    return byId.get(id);
	 }
	 
	public static Language getByValue(String value) {
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
	private Language(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, Language> getByid() {
		return byId;
	}

	public static Map<String, Language> getByvalue() {
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
