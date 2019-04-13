package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Question;
import model.Quiz;
import services.PanelFactory;
import utilities.FileManager;
import view.CreateQuizPanel;
import view.PanelType;
import view.ProfessorView;

/**
 * Controller class to manage different panels
 * 
 * @author ishansarangi
 *
 */
public class ProfessorController {
	ProfessorView view;
	ArrayList<Question> questionList;
	Quiz quiz;
	String quizNAme;

	public ProfessorController() {
		view = new ProfessorView();
		questionList = new ArrayList<Question>();
		setDashboardView();
	}

	private JPanel setViewForPanelType(PanelType type, ActionListener[] listeners) {
		JPanel panel = PanelFactory.getPanel(type, listeners);
		view.getContentPane().removeAll();
		view.setPanel(panel);
		view.invalidate();
		view.validate();
		view.repaint();
		view.setVisible(true);
		return panel;
	}

	private void setDashboardView() {
		ActionListener createButtonListener = e -> createButtonClicked();
		ActionListener editButtonListener = e -> editButtonClicked();
		ActionListener[] listeners = { createButtonListener, editButtonListener };
		setViewForPanelType(PanelType.Dashboard, listeners);
	}

	private void createButtonClicked() {
		
		ActionListener submitQuizButtonListener = e -> submitQuizButtonClicked();
		ActionListener[] listeners = { submitQuizButtonListener };
		
		CreateQuizPanel panel = (CreateQuizPanel) setViewForPanelType(PanelType.CreateQuiz, listeners);
		panel.getaddQuestionButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.checkEntryExists()) {
					quizNAme = panel.getQuizName();
					questionList.add(panel.getQuizQuestions());
					panel.clearTextAndSelection();
				}
			}
		});
	}
	
	private void submitQuizButtonClicked() {
		ActionListener saveQuizButtonListener = e -> saveQuizButtonClicked();
		ActionListener[] listeners = { saveQuizButtonListener };
		
		setViewForPanelType(PanelType.SaveQuiz, listeners);
	}
	
//	private void getQuizQuestions() {
//		CreateQuizPanel panelView = new CreateQuizPanel();
//		questionList.add(panelView.getQuizQuestions());
//	}

	private void editButtonClicked() {
		ActionListener backButtonListener = e -> backButtonClicked();
		ActionListener nextButtonListener = e -> nextButtonClicked();
		ActionListener[] listeners = { backButtonListener, nextButtonListener };

		setViewForPanelType(PanelType.EditQuiz, listeners);
	}

	private void backButtonClicked() {
		setDashboardView();
	}

	private void nextButtonClicked() {
		System.out.println("Next button clicked");
	}

	private void saveQuizButtonClicked() {
		try {
			quiz = new Quiz(questionList);
			quiz.setName(quizNAme);
			FileManager manager = FileManager.getInstance();
			manager.writeFile(quiz);
			setDashboardView();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO: To be deleted once date is setup
	protected static Quiz TestSetupData() {

		// Question 1 details
		Question q1 = new Question();
		q1.setQuestionTitle("Question 1");
		ArrayList<String> optionsQuestion1 = new ArrayList<String>();
		optionsQuestion1.add("Question1_Option1");
		optionsQuestion1.add("Question1_Option2");
		optionsQuestion1.add("Question1_Option3");
		optionsQuestion1.add("Question1_Option4");
		q1.setOptions(optionsQuestion1);
		q1.setCorrectAnswer("Question1_Option2");

		// Question 2 details
		Question q2 = new Question();
		q2.setQuestionTitle("Question 2");
		ArrayList<String> optionsQuestion2 = new ArrayList<String>();
		optionsQuestion2.add("Question2_Option1");
		optionsQuestion2.add("Question2_Option2");
		optionsQuestion2.add("Question2_Option3");
		optionsQuestion2.add("Question2_Option4");
		q2.setOptions(optionsQuestion2);
		q2.setCorrectAnswer("Question2_Option4");

		Quiz quiz = new Quiz();
		ArrayList<Question> questionsList = new ArrayList<Question>();
		questionsList.add(q1);
		questionsList.add(q2);

		quiz.setName("Quiz_1");
		quiz.setQuestions(questionsList);

		return quiz;
	}

}
