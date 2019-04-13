package model;

import java.util.ArrayList;

/**
 * This is the model class for quiz
 * 
 * @author viraj
 */
public class Quiz {

	private String name;
	private ArrayList<Question> questions;

	public Quiz() {
		super();
	}

	public Quiz(ArrayList<Question> questions) {
		super();
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

}
