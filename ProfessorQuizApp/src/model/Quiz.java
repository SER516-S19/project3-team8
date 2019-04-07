package model;

import java.util.ArrayList;

public class Quiz {

	String quizName;
	String quizLocation;
	ArrayList<Question> questions = new ArrayList<Question>();

	
	
	
	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getQuizLocation() {
		return quizLocation;
	}

	public void setQuizLocation(String quizLocation) {
		this.quizLocation = quizLocation;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}


	

}
