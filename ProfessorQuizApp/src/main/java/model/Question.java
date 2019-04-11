package model;

import java.util.ArrayList;

public class Question {
	String title;
	String correctAnswer;
	ArrayList<String> options;

	public Question() {
		super();
	}

	public Question(String title, String correctAnswer, ArrayList<String> options) {
		super();
		this.title = title;
		this.correctAnswer = correctAnswer;
		this.options = options;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	
	
}
