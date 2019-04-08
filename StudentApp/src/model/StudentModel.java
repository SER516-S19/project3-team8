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
 * @date 4/6/2019
 * @since 4/3/2019
 * */
public class StudentModel {
	private JSONArray questions;
	private boolean isFinished;
	private boolean quit = false;
	private int index = 0;
	/**
	 * Constructor readsFile and sets up questions array
	 * @param filePath needs Absolute file path
	 * */
	public StudentModel(String filePath) {	
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(new FileReader(filePath));
			questions= (JSONArray) json.get("questions");
				
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
		JSONObject question  = (JSONObject) questions.get(index);
		if(selected.equals(question.get("correctAnswer"))) {
			questions.remove(index);
			flag = true;	
		}
		return flag;
	}
	
	/**
	 * 
	 * Returns the next value of the array
	 * @param index current position
	 * @return next position
	 * */
	public int nextIndex(){
		return index + 1;
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
	 * 
	 * @return quit true if the user has given up.
	 * */
	public boolean hasGivenUp() {
		return quit = true;
	}
}