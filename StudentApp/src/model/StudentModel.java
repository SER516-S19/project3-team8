package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The Questions class divides the arrayList of questions present in the 
 * file and displays it in the front end.
 * 
 * @author Aditya Samant
 * @author Jainish Soni
 * @author Aprajita Thakur
 * @date 4/6/2019
 * @since 4/3/2019
 * */

public class StudentModel {
  
	private JSONArray questions;
	private boolean isFinished;
	private int index = 0;
	private String filePath;
	private String correctAnswer;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		}
	
  	public String getFilePath() {
		return filePath;
  		}
  
  /* 
   * 
   * Sets the questions JSON array with the questions in the given quiz file.
   *  @param filePath path of file selected
   *  
   *   */
	public void setJsonArray(String filePath) {
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(new FileReader(filePath));
			questions= (JSONArray) json.get("questions");
			System.out.println("JSONArray: " + questions);
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found\n");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException er) {
			System.out.println("I/O Error has occured\n");
			er.printStackTrace();
			System.exit(0);
		}catch(ParseException ex) {
			System.out.println("ParseException: Cannot parse file to JSON object");
			ex.printStackTrace();
			System.exit(0);
		}
	}
  
  /**
	 * getter for questions in quiz.
	 * @return questions
	 * */
	public JSONArray getQuestions() {
		return questions;
	}
	
	/**
	 * Checks if student answered question correctly and removes it from object
	 * if answered correctly.
	 * @return flag Student answered correctly
	 * */
	public boolean checkIfCorrect(int index, String selected) {
		boolean flag = false;
		
		if(selected.equals(correctAnswer)) {
			questions.remove(index);
			flag = true;	

		}
		return flag;
	}
	
	/**
	 * 
	 * Returns the current value of the array
	 * @param index current position
	 * @return current position
	 * */
	public int getIndex(){
		return index;
	}
	
	/**
	 * 
	 * Returns the next value of the array
	 * @param index current position
	 * @return next position
	 * */
	public int nextIndex(){
		return ++index;
	}
	

	/**
	 * Checks if student is finished with quiz.
	 * @return isFinished 
	 * */
	
	public boolean checkIfDone() {
		if(questions.isEmpty()) {
			isFinished = true;
		}else {
			isFinished = false;
		}
		return isFinished;
	}
	
	/**
	 * checks the question displayed is the last element in the array.
	 * @param index position of the question displayed in the list. 
	 * @return isLast 
	 * */
	public boolean checkIsNextToLast(int index) {
		boolean isNextToLast = false;
		if(index == questions.size()-2) {
			isNextToLast = true;
		}
		return isNextToLast;
	}
	
	/**
	 * checks the question displayed is the last element in the array.
	 * @param checks size of array 
	 * @return isLastElement 
	  */
	public boolean checkIsLastElement() {
		boolean isLastElement = false;
		if(questions.size() == 1) {
			isLastElement = true;
		}
		return isLastElement;
	}


	/**
	 * 
	 * Returns the value of the array after reset
	 * @param index current position
	 * @return first position in array
	  */
	public int resetIndex(){
		return index = 0;
	}
	
	/**
	 * The codes resetData and resetOptions resets questions array 
	 * and allows for the data to be retrieved.
	 * */
	public String resetData() {
		JSONObject question = (JSONObject) questions.get(index);
		String title = question.get("title").toString();
		String correctAnswer = question.get("correctAnswer").toString();
		this.setCorrectAnswer(correctAnswer);
		System.out.println("CorrectAns:" + correctAnswer);
		return title;
	}
	
	
	public JSONArray resetOptions() {
		JSONObject question = (JSONObject) questions.get(index);
		JSONArray options = (JSONArray) question.get("options");
		return options;
	}
	
	/**
	 * 
	 * @return quit true if the user has given up.
	 * */
	public boolean hasGivenUp() {
		return true;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	public void setCorrectAnswer(String answer) {
		correctAnswer = answer;
	}
}