package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StudentModel;
import view.NextPanel;
import view.QuitPanel;
import view.StudentView;
;


/**
 * Student controller links the Models and the different Views of the program
 * 
 * */
public class StudentController {
	private StudentView quizView;
	private StudentModel quizModel;
	private NextPanel nextPanel;
	private QuitPanel quitPanel;
	
	public StudentController(StudentModel studentModel, StudentView studentView) {
			quizView = studentView;
			quizModel = studentModel;
			
			nextPanel = quizView.getNextPanel();
			nextPanel.addNextListener(new NextListener());
			nextPanel.addGiveUpListener(new GiveUpListener());
			quitPanel = quizView.getQuitPanel();
			
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
