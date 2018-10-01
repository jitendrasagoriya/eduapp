package com.jitendra.eduapp.enums;

import java.util.HashMap;
import java.util.Map;

 
/**
 * @author jitendra sagoriya
 *
 */
public enum ConceptType {
	
	ONE(10001,"CONCEPTTYPE1","CONCEPTTYPE1"),
	CONCEPTTYPE2(10002,"CONCEPTTYPE2","CONCEPTTYPE2"),
	CONCEPTTYPE3(10003,"CONCEPTTYPE3","CONCEPTTYPE3"),
	CONCEPTTYPE4(10004,"CONCEPTTYPE4","CONCEPTTYPE4");
	
	
	private static final Map<Integer, ConceptType> byId = new HashMap<Integer, ConceptType>();
	private static final Map<String, ConceptType> byValue = new HashMap<String, ConceptType>();
	
	
	static {
	     for (ConceptType e : ConceptType.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	
	public static ConceptType getById(int id) {
	    return byId.get(id);
	 }
	 
	public static ConceptType getByValue(String value) {
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
	private ConceptType(Integer id, String value, String desc) {
		this.id = id;
		this.value = value;
		this.desc = desc;
	}

	public static Map<Integer, ConceptType> getByid() {
		return byId;
	}

	public static Map<String, ConceptType> getByvalue() {
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
