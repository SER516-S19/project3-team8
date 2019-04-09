package view;

import controller.StudentController;
import model.StudentModel;

/**
 * Implements MVC pattern by initializing the Model, the View and the Controller
 * And starting the program.
 * 
 * @author Aditya Samant
 * 
 * */
public class StudentAppMVC {
	public static void main(String[] args) {
		StudentModel model = new StudentModel();
		StudentView view = new StudentView();
		
		StudentController controller = new StudentController(model, view);
		
		
	}
}
