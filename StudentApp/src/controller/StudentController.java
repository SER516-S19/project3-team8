package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import model.StudentModel;
import view.StudentDashboard;
import view.StudentView;
import view.NextPanel;
import view.QuitPanel;

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
   private NextPanel nextPanel;
	 private QuitPanel quitPanel;
	 private StudentDashboard studentDashBoard;
	 public static String currentFilePath;
	 
	  public StudentController(StudentModel studentModel,StudentView studentView) {
		  quizModel = studentModel;
		  quizView = studentView;
		  studentDashBoard = studentView.getStudenDashboard(); 
		  studentDashBoard.addLoadQuizListener(new LoadQuizListener());
		  studentDashBoard.addTakeQuizListener(new TakeQuizListener());
			nextPanel = quizView.getNextPanel();
			nextPanel.addNextListener(new NextListener());
			nextPanel.addGiveUpListener(new GiveUpListener());
			quitPanel = quizView.getQuitPanel();
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

	class NextListener implements ActionListener{

		
		public void actionPerformed(ActionEvent event) {
			try {
				int index = nextPanel.getIndex();
				if(quizModel.checkIsNextToLast(index)) {
					//CheckIfCorrect
					//Enter code to change last button to submit button.
				}else {
					//checkIfCorrect Method from StudentView goes here
					quizModel.nextIndex();
				}
			}catch(NumberFormatException ex) {
				System.out.println("Index did not return an integer value");
				System.exit(0);
			}
		}
		
	}
	
	class GiveUpListener implements ActionListener{	
		public void actionPerformed(ActionEvent event) {
			try {
				System.out.println("ActionListener GiveUp");
				boolean quit = quizModel.hasGivenUp();
				if(quit) {
					//change current panel and add a new one.
					quizView.getContentPane().removeAll();
					quizView.getContentPane().add(quitPanel);
					quizView.revalidate();
				}
				
			}catch(Exception error){
				error.printStackTrace();
				System.exit(0);
			}
		}
		
	}
}
