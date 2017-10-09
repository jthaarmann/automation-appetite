package com.jth.rest.restservices.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jth.rest.restservices.data.RestEntity;

@Entity
@Table(name = "FOOD_ITEM")
public class FoodItem  implements RestEntity, Serializable {

	private static final long serialVersionUID = -2840017342935477004L;

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name="FOOD_GROUP", referencedColumnName = "NAME")	
	private FoodGroup group;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodGroup getGroup() {
		return group;
	}

	public void setGroup(FoodGroup group) {
		this.group = group;
	}

}
