import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentDashboard  {
	JFrame frame = new JFrame("Quiz Application");
	JPanel panel = new JPanel();
	String quizzes[] = { "Quiz1", "Quiz2", "Quiz3", "Quiz4", "Quiz5" };
	JComboBox comboBox= new JComboBox(quizzes);
	JButton button = new JButton("Take Quiz");
	JLabel pageName = new JLabel("Student Dashboard");

	JLabel selectQuizName = new JLabel("Select Quiz"); 

	//Create Student dashboard
	public StudentDashboard() {
		panel.setLayout(new GridLayout(4,1,2,30));
		panel.add(pageName);
		panel.add(selectQuizName);
		panel.add(comboBox);
		panel.add(button);
		
		frame.add(panel);
		
		frame.pack();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
}
