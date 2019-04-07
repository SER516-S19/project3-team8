package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StudentModel;
import view.QuitPanel;
import view.QuizPanel;


/**
 * Student controller links the Models and the different Views of the program
 * 
 * */
public class StudentController {
	private QuizPanel quizView;
	private StudentModel zeModel;
	private QuitPanel quitView;
	
	public StudentController(QuizPanel View, StudentModel Model, QuitPanel View2) {
			quizView = View;
			zeModel = Model;
			quitView = View2;
			
			quizView.addNextListener(new NextListener());
			quizView.addGiveUpListener(new GiveUpListener());
	}
	class NextListener implements ActionListener{

		
		public void actionPerformed(ActionEvent event) {
			try {
				int index = quizView.getIndex();
				if(zeModel.checkIsLast(index)) {
					//Enter code to change last button to submit button.
				}else {
					quizView.setNextIndex(zeModel.nextIndex(index));
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
				boolean quit = zeModel.hasGivenUp();
				if(quit) {
					quizView.setVisible(false);
					quitView.setVisible(true);
				}
				
			}catch(Exception error){
				error.printStackTrace();
				System.exit(0);
			}
		}
		
	}
}
