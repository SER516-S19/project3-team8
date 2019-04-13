package model;

import java.util.ArrayList;

public class Question {
	String questionTitle;
	String correctAnswer;
	ArrayList<String> options = new ArrayList<String>();
	
	public Question() {
		super();
	}

	public Question(String questionTitle, String correctAnswer, ArrayList<String> options) {
		super();
		this.questionTitle = questionTitle;
		this.correctAnswer = correctAnswer;
		this.options = options;
	}
	
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
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
