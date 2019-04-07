package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerid;
	private String value;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy ="answer")
	private List<Question> questions;

	public Answer() {
		super();
		this.value = null;
	}

	public Answer(String value) {
		super();
		this.value = value;
	}

	public Long getAnswerid() {
		return answerid;
	}

	public void setAnswerid(Long answerid) {
		this.answerid = answerid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Answer [answerid=" + answerid + ", value=" + value + ", questions=" + questions + "]";
	}
	
	
	
	
	
	
}
