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
 * @version 1.0
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

	
	public StudentDashboard() {
		this.setLayout(new GridLayout(4,1,2,10));
		this.add(pageName);
		this.add(selectQuizName);
		this.add(loadQuiz);
		this.add(takeQuiz);	
	}
	public void addLoadQuizListener(ActionListener listenForClick) {
		loadQuiz.addActionListener(listenForClick);
	}

	

}



  




