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
@Table(name = "EXERCISE_SESSION")
public class ExerciseSession implements Serializable, RestEntity {

	private static final long serialVersionUID = -5678995496799854038L;

	@Id
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="EXERCISE", referencedColumnName = "ID")	
	private Exercise exercise;

	@ManyToOne
	@JoinColumn(name="DAY", referencedColumnName = "ID")	
	private Day day;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}
}
