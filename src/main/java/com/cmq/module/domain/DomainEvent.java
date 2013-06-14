
package com.cmq.module.domain;

import java.io.Serializable;

import com.cmq.module.jgroups.User;

public class DomainEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6625246275827657020L;
	private String code;
	private String name;
	private User owner;
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public DomainEvent(String code, String name,User owner) {
		super();
		this.code = code;
		this.name = name;
		this.owner=owner;
	}

	public User getOwner() {
		return owner;
	}
	
	
}
