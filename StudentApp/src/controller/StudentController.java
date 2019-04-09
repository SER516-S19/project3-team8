package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import model.StudentModel;
import view.StudentDashboard;

/**
 * StudentController which connects the StudentModel and 
 * StudentDashboard to display the Quiz view
 * @author appy
 * @version 1.0
 *
 */

public class StudentController {

	 private StudentModel studentModel;
	 private StudentDashboard studentDashBoard;
	 public static String currentFilePath;
	 
	  public StudentController(StudentModel studentModel,StudentDashboard studentDashBoard) {
		  this.studentModel = studentModel;
		  this.studentDashBoard = studentDashBoard;
		  studentDashBoard.addLoadQuizListener(new LoadQuizListener());
	  }
	  class LoadQuizListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					int returnValue = fileChooser.showOpenDialog(null);
					if(returnValue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						System.out.println("inside actionlistener"+selectedFile.getAbsolutePath());
						currentFilePath = selectedFile.getAbsolutePath();
					}
				
				}
			}
	  }

	  
  