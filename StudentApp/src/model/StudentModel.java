package model;

import java.awt.event.ActionEvent;
import java.io.File;

import controller.StudentController;
import view.StudentDashboard;

/**
 * StudentController which connects the StudentModel and 
 * StudentDashboard to display the Quiz view
 * @author appy
 * @version 1.0
 *
 */

public class StudentModel {
	private String filePath;
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFilePath() {
		return StudentController.currentFilePath;
	}
	}

