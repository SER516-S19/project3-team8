package view;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.StudentController;
import model.StudentModel;

/**
 * StudentView which will take data from model and manipluates
 * in the StudentController and display here on StudentDashboard
 * @author appy
 * @version 1.0
 *
 */
public class StudentView extends JFrame{
	private StudentDashboard  studenDashboard= new StudentDashboard();
	public StudentDashboard getStudenDashboard() {
		return studenDashboard;
	}
	StudentView(){
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(studenDashboard);
		this.setVisible(true);
	}
	
}

