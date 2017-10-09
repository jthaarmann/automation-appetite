package com.jth.rest.restservices.data.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jth.rest.restservices.data.RestEntity;

@Entity
@Table(name = "FOOD_GROUP")
public class FoodGroup  implements RestEntity, Serializable {

	private static final long serialVersionUID = 2552554499706243036L;

	@Id
	@Column(name = "NAME")
	private String name;
	
	@OneToMany
	@JoinColumn(name = "FOOD_GROUP")
	private List<FoodItem> foodItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

}
