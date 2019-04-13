package app;

import controller.StudentController;
import model.StudentModel;
import view.StudentView;

/**
 * Implements MVC pattern by initializing the Model, the View and the Controller
 * And starting the program.
 * 
 * @author Aditya Samant
 * @author Aprajita Thakur
 * 
 * */
public class StudentAppMVC {
	public static void main(String[] args) {
		StudentModel model = new StudentModel();
		StudentView view = new StudentView();
		new StudentController(model, view);
		
		
	}

}

