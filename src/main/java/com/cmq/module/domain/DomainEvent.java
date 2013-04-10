
package com.cmq.module.domain;

public class DomainEvent {

	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public DomainEvent(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	
}
