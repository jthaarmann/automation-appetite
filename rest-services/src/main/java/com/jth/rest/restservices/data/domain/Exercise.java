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
@Table(name = "EXERCISE")
public class Exercise implements Serializable, RestEntity {

	private static final long serialVersionUID = -2350288322679761079L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="TYPE_CODE", referencedColumnName = "TYPE_CODE")	
	private ExerciseType exerciseType;

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

	public ExerciseType getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(ExerciseType exerciseType) {
		this.exerciseType = exerciseType;
	}

}
