package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * StudentView which will take data from model and manipluates
 * in the StudentController and display here on StudentDashboard
 * @author appy
 * @author Aditya Samant
 * @author Jainish Soni
 * @author Sami
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class StudentView extends JFrame{
	private StudentDashboard  studenDashboard= new StudentDashboard();
	private NextPanel nextPanel = new NextPanel();
	private QuitPanel quitPanel = new QuitPanel();
	private QuizSubmittedPanel quizSubmittedPanel = new QuizSubmittedPanel();
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
	
	public QuizSubmittedPanel getQuizSubmittedPanel() {
		return quizSubmittedPanel;
	}
	
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	
	public ShowQuestionsPanel getShowQuestionsPanel() {
		showQuestionsPanel = new ShowQuestionsPanel();
		return showQuestionsPanel;
	}
	
	/**
	 * 
	 * Used to remove redundant repeated statements in controller:
	 * revalidatePanel methods render panel(s) onto JFrame.
	 * */
	public void revalidatePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.repaint();
		this.setLayout(new GridLayout(2, 1));
		this.getContentPane().add(panel);
		this.revalidate();
	}
	
	
	public void revalidatePanel(JPanel panel, JPanel panel2) {
		this.getContentPane().removeAll();
		this.repaint();
		this.setLayout(new GridLayout(2, 1));
		this.getContentPane().add(panel);
		this.getContentPane().add(panel2);
		this.revalidate();
	}

  StudentView(){
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(studenDashboard);
		this.setTitle("Student Dashboard");
		this.setVisible(true);
		
	}
	
}
