package model;

import java.util.ArrayList;

public class Quiz {

	ArrayList<Question> questions;


	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
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
