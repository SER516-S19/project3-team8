package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import controller.StudentController;
import model.StudentModel;

/**
 * StudentView which will take data from model and manipluates
 * in the StudentController and display here on StudentDashboard
 * @author appy
 * @author Aditya
 * @author Jainish
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class StudentView extends JFrame{
	private StudentDashboard  studenDashboard= new StudentDashboard();
	private NextPanel nextPanel = new NextPanel();
	private QuitPanel quitPanel = new QuitPanel();
	private ShowQuestionsPanel showQuestionsPanel;
	
	public StudentDashboard getStudenDashboard() {
		return studenDashboard;
   	}
  
	public NextPanel getNextPanel() {
		return nextPanel;
   	}
	
	public QuitPanel getQuitPanel() {
		return quitPanel;
	}
	
	public ShowQuestionsPanel getShowQuestionsPanel() {
		showQuestionsPanel = new ShowQuestionsPanel();
		return showQuestionsPanel;
	}
	
  StudentView(){
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(studenDashboard);
		this.setTitle("Student Dashboard");
		this.setVisible(true);
		
	}
	
}
