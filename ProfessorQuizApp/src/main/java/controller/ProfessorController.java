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
 * @author ishansarangi, alshasamantaray
 */
public class ProfessorController {
	private ProfessorView view;
	private ArrayList<Question> questionList;
	private Quiz quiz;
	private String quizName;

	public ProfessorController() {
		view = new ProfessorView();
		questionList = new ArrayList<Question>();
		setDashboardView();
	}

	private JPanel setViewForPanelType(PanelType type, ActionListener[] listeners) {
		JPanel panel = PanelFactory.getPanel(type, listeners);
		view.getContentPane().removeAll();
		view.add(panel);
		view.invalidate();
		view.validate();
		view.repaint();
		view.setVisible(true);
		return panel;
	}

	private void setDashboardView() {
		ActionListener createButtonListener = e -> createButtonClicked();
		ActionListener editButtonListener = e -> listQuizButtonClicked();
		ActionListener[] listeners = { createButtonListener, editButtonListener };
		setViewForPanelType(PanelType.Dashboard, listeners);
	}

	private void listQuizButtonClicked() {
		ActionListener backButtonListener = e -> setDashboardView();
		ActionListener[] listeners = { backButtonListener };
		setViewForPanelType(PanelType.ListQuiz, listeners);

	}

	private void createButtonClicked() {	
		ActionListener cancelButtonListener = e -> backButtonClicked();
		ActionListener[] listeners = {cancelButtonListener};
		CreateQuizPanel panel = (CreateQuizPanel) setViewForPanelType(PanelType.CreateQuiz, listeners);
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
					quizName = panel.getQuizName();
					questionList.add(panel.getQuizQuestions());
					saveQuizButtonClicked();
					}
			}
		});
	}

	private void backButtonClicked() {
		setDashboardView();
	}

	private void saveQuizButtonClicked() {
		try {
			quiz = new Quiz(questionList);
			quiz.setName(quizName);
			FileManager manager = FileManager.getInstance();
			manager.writeFile(quiz);
			setDashboardView();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
