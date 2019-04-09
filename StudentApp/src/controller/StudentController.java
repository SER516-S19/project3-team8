package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import model.StudentModel;
import view.StudentDashboard;
import view.StudentView;

/**
 * StudentController which connects the StudentModel and 
 * StudentDashboard to display the Quiz view
 * @author appy
 * @version 1.1
 *
 */

public class StudentController {
	 private StudentView quizView;
	 private StudentModel quizModel;
	 private StudentDashboard studentDashBoard;
	 public static String currentFilePath;
	 
	  public StudentController(StudentModel studentModel,StudentView studentView) {
		  quizModel = studentModel;
		  quizView = studentView;
		  studentDashBoard = studentView.getStudenDashboard(); 
		  studentDashBoard.addLoadQuizListener(new LoadQuizListener());
		  studentDashBoard.addTakeQuizListener(new TakeQuizListener());
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
						quizModel.setFilePath(currentFilePath);
					}
				
				}
			}
	  class TakeQuizListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//quizModel.setJSONArray(quizModel.getFilePath());
			System.out.println(quizModel.getFilePath());
			
		}
		  
	  }
	  }

	  
  