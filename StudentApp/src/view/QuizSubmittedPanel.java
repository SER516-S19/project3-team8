package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class QuizSubmittedPanel extends JPanel {
	
	JLabel quizSubmitMsg = new JLabel("Your Quiz has been Submitted Successfully", JLabel.CENTER);
	
	QuizSubmittedPanel(){
		quizSubmitMsg.setFont(new Font("Georgia", Font.BOLD, 20));
		this.add(quizSubmitMsg); 
		
	}

}
