package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="answerid")
	private Answer answer;
	
	
	
	public Question() {
		super();
		this.id = null;
		this.title = null;
	}


	public Question(String title) {
		super();
		this.title = title;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	


	public Answer getAnswer() {
		return answer;
	}


	public void setAnswer(Answer answer) {
		this.answer = answer;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		if(this.answer != null) {
			return "Question [id=" + id + ", title=" + title + "answer =" + this.getAnswer() + "]";
		} else {
			return "Question [id=" + id + ", title=" + title + "]";
		}
		
	}
}
