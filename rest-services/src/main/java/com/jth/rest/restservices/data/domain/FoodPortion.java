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
@Table(name = "FOOD_PORTION")
public class FoodPortion  implements RestEntity, Serializable {

	private static final long serialVersionUID = 634221364487316118L;

	@Id
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="ITEM", referencedColumnName = "ID")	
	private FoodItem item;

	@ManyToOne
	@JoinColumn(name="DAY", referencedColumnName = "ID")	
	private Day day;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FoodItem getItem() {
		return item;
	}

	public void setItem(FoodItem item) {
		this.item = item;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

}
