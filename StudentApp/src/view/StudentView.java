package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.StudentController;
import model.StudentModel;



public class StudentView {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("StudentApp");
				frame.setSize(500,400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				QuizPanel quizPanel = new QuizPanel();
				frame.add(quizPanel);
				
				QuitPanel giveUp = new QuitPanel();
				StudentModel model = new StudentModel("");
				
				StudentController control = new StudentController(quizPanel,model,giveUp);
			}
		});
		

	}

}
