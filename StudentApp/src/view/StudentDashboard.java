package view;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

/**
 * StudentDashboard which displays the quiz student's
 * homepage 
 * @author appy
 * @version 1.1
 *
 */

public class StudentDashboard extends JPanel{
	JButton loadQuiz = new JButton("Load Quiz");
	public JButton getLoadQuiz() {
		return loadQuiz;
	}
	
	JButton takeQuiz = new JButton("Take Quiz");
	JLabel pageName = new JLabel("Student Dashboard");
	JLabel selectQuizName = new JLabel("Select Quiz"); 

	
	public StudentDashboard(){
		selectQuizName.setFont(new Font("Georgia",Font.BOLD,24));
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints(); 
		constraint.insets = new Insets(20,20,20,20);
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		this.add(selectQuizName,constraint);
		constraint.gridx = 0;
		constraint.gridy = 20;
		this.add(loadQuiz,constraint);
		constraint.gridx = 0;
		constraint.gridy = 40;
		this.add(takeQuiz,constraint);	
	}
	public void addLoadQuizListener(ActionListener listenForClick) {
		loadQuiz.addActionListener(listenForClick);
	}
	public void addTakeQuizListener(ActionListener loadquizPage) {
		takeQuiz.addActionListener(loadquizPage);
	}
}



  




