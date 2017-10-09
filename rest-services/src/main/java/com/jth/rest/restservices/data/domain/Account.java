package com.jth.rest.restservices.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jth.rest.restservices.data.RestEntity;

@Entity
@Table(name = "ACCOUNT")
public class Account implements RestEntity, Serializable {

	private static final long serialVersionUID = 2723201219748255804L;

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "NAME")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
