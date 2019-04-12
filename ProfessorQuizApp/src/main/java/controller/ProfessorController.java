package controller;
import view.CreateQuizPanel;
import view.DashboardPanel;
import view.EditQuizPanel;
import view.ProfessorView;
import view.SaveQuizPanel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import model.Question;
import model.Quiz;
import utilities.FileManager;

public class ProfessorController {
	
	ProfessorView view;
	DashboardPanel dashboardPanel;
	CreateQuizPanel createQuizPanel;
	EditQuizPanel editQuizPanel;
	SaveQuizPanel saveQuizPanel;
	
	public ProfessorController() {
		view = new ProfessorView();
		setDashboardView();		
	}

	private void createButtonClicked() {
		setCreateQuizView();
	}
	
	private void submitQuizButtonClicked() {
		setSaveQuizView();
	}

	private void editButtonClicked() {
		setEditQuizView();
	}
	
	private void backButtonClicked() {
		setDashboardView();
	}
	
	private void nextButtonClicked() {
		System.out.println("Next button clicked");
	}

	private void saveQuizButtonClicked() {
		try {
			Quiz quiz = TestSetupData();
			FileManager fm = FileManager.getInstance();
			fm.writeFile(quiz);
			setDashboardView();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// All the methods to update the panels on the frame written below
	private void setDashboardView() {
		dashboardPanel = new DashboardPanel();
		view.getContentPane().removeAll();
		view.setPanel(dashboardPanel);
		view.invalidate();
		view.validate();
		view.repaint();
		dashboardPanel.getCreateQuizButton().addActionListener(e -> createButtonClicked());
		dashboardPanel.getEditQuizButton().addActionListener(e -> editButtonClicked());
		view.setVisible(true);
	}

	private void setEditQuizView() {
		editQuizPanel = new EditQuizPanel();
		view.getContentPane().removeAll();
		view.setPanel(editQuizPanel);
		editQuizPanel.getBackButton().addActionListener(e -> backButtonClicked());
		editQuizPanel.getNextButton().addActionListener(e -> nextButtonClicked());
		view.invalidate();
		view.validate();
		view.repaint();
	}
	
	private void setCreateQuizView() {
		createQuizPanel = new CreateQuizPanel();
		createQuizPanel.getSubmitQuizButton().addActionListener(e -> submitQuizButtonClicked());
		view.getContentPane().removeAll();
		view.setPanel(createQuizPanel);
		view.invalidate();
		view.validate();
		view.repaint();
	}

	private void setSaveQuizView() {
		saveQuizPanel = new SaveQuizPanel();
		saveQuizPanel.getSaveButton().addActionListener(e -> saveQuizButtonClicked());
		view.getContentPane().removeAll();
		view.setPanel(saveQuizPanel);
		view.invalidate();
		view.validate();
		view.repaint();
	}
	
	
	
	//To be deleted once date is setup
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
