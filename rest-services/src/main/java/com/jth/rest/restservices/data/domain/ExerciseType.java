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
@Table(name = "EXERCISE_TYPE")
public class ExerciseType  implements RestEntity, Serializable {

	private static final long serialVersionUID = 4048788504835438286L;

	@Id
	@Column(name = "TYPE_CODE")
	private String type;

	@Column(name = "NAME")
	private String name;
	
	@OneToMany
	@JoinColumn(name = "TYPE_CODE")
	private List<Exercise> exercises;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
}
