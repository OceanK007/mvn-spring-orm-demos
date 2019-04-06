package com.ocean.mvn.spring.orm.demos.data.dto;

import java.io.Serializable;

/** 
	Abstract classes improve the situation by preventing a developer from instantiating the base class, because a developer has marked it as having missing functionality.
**/
public abstract class AbstractMasterDTO implements Serializable
{
	private static final long serialVersionUID = -416930898735479578L;
	
	private Long id;
	private Long dateCreated;
	private Long dateModified;
	private String zoneId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Long dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Long getDateModified() {
		return dateModified;
	}
	public void setDateModified(Long dateModified) {
		this.dateModified = dateModified;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
}
