package model;

import java.util.ArrayList;

public class Quiz {

	private String name;
	private ArrayList<Question> questions;

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Quiz(ArrayList<Question> questions) {
		super();
		this.questions = questions;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

}
