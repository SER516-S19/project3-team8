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
 * @author ishansarangi, alshasamantaray
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
		CreateQuizPanel panel = (CreateQuizPanel) setViewForPanelType(PanelType.CreateQuiz, null);
		panel.getaddQuestionButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.checkEntryExists()) {
					questionList.add(panel.getQuizQuestions());
					panel.clearTextAndSelection();
				}
			}
		});
		panel.getSubmitQuizButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.checkEntryExists()) {
					quizNAme = panel.getQuizName();
					questionList.add(panel.getQuizQuestions());
					saveQuizButtonClicked();
					}
			}
		});
	}

	private void submitQuizButtonClicked() {
		ActionListener saveQuizButtonListener = e -> saveQuizButtonClicked();
		ActionListener[] listeners = { saveQuizButtonListener };

		setViewForPanelType(PanelType.SaveQuiz, listeners);
	}

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
}
