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
public class StudentView {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StudentModel studentModel = new StudentModel();
				StudentDashboard studentDashboard = new StudentDashboard();
				StudentController studentController = new StudentController(studentModel,studentDashboard);
				System.out.println(studentModel.getFilePath());
				JFrame frame = new JFrame("StudentApp");
				frame.setSize(500,400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(studentDashboard);
				frame.setVisible(true);
			}
		});
		

	}

}