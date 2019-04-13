package controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.StudentModel;
import view.StudentDashboard;
import view.StudentView;
import view.NextPanel;
import view.QuitPanel;
import view.ShowQuestionsPanel;
import view.QuizSubmittedPanel;

/**
 * StudentController which connects the StudentModel and 
 * StudentDashboard to display the Quiz view
 * @author appy
 * @author Jainish
 * @author Sajith Thattazhi
 * @author Sami
 * @version 1.1
 *
 */

public class StudentController {
	private StudentView quizView;
	private StudentModel quizModel;
	private NextPanel nextPanel;
	private QuitPanel quitPanel;
	private QuizSubmittedPanel quizSubmitPanel;
	private StudentDashboard studentDashBoard;
	private ShowQuestionsPanel questionsPanel;
	private String currentFilePath;

	public StudentController(StudentModel studentModel,StudentView studentView) {
		quizModel = studentModel;
		quizView = studentView;

		studentDashBoard = quizView.getStudenDashboard();
		studentDashBoard.addLoadQuizListener(new LoadQuizListener());
		studentDashBoard.addTakeQuizListener(new TakeQuizListener());

		questionsPanel = quizView.getShowQuestionsPanel();

		nextPanel = quizView.getNextPanel();
		nextPanel.addNextListener(new NextListener());

		nextPanel.addGiveUpListener(new GiveUpListener());
		
		nextPanel.addSubmitListener(new SubmitListener());
		
		quitPanel = quizView.getQuitPanel();
		
		quizSubmitPanel = quizView.getQuizSubmittedPanel();
		
	}
	class LoadQuizListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = fileChooser.showOpenDialog(null);
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();

				currentFilePath = selectedFile.getAbsolutePath();
				quizModel.setFilePath(currentFilePath);
			}

		}
	}
	class TakeQuizListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String filePath = quizModel.getFilePath();
				quizModel.setJsonArray(filePath);
				JSONArray questions = quizModel.getQuestions();
				int index = quizModel.getIndex();

				JSONObject question = (JSONObject) questions.get(index);
				String title = question.get("title").toString();
				JSONArray options = (JSONArray) question.get("options");
				String correctAnswer = question.get("correctAnswer").toString();
				questionsPanel.setQuestionLabel(title);
				questionsPanel.setOptionRadioButton(options);
				System.out.println("CorrectAns:" + correctAnswer.toString());
				quizModel.setCorrectAnswer(correctAnswer.toString());
				quizView.getContentPane().removeAll();
				quizView.setLayout(new GridLayout(2, 1));
				quizView.getContentPane().add(questionsPanel);
				quizView.getContentPane().add(nextPanel);
				quizView.revalidate();
			} catch(NullPointerException exc) {
				quizView.displayMessage("File not selected");
				exc.printStackTrace();
			}
		}

	}

	class NextListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			try {
				int index = quizModel.getIndex();
				System.out.println("index:" + index);
				if(quizModel.checkIsNextToLast(index) ) {
					nextPanel.next.setVisible(false);
					nextPanel.submit.setVisible(true);	
				}
					ButtonGroup group = questionsPanel.getButtonGroup();
					String selected = group.getSelection().getActionCommand();
					
					boolean isIncorrect = !(quizModel.checkIfCorrect(index, selected));
					System.out.println("Incorrect:" + isIncorrect);
					if(isIncorrect) {
						System.out.println("IsIncorrect");
						index = quizModel.nextIndex();
					}
					group.clearSelection();
					quizView.getContentPane().removeAll();
					//Reset all info.
					JSONArray questions = quizModel.getQuestions();    
					JSONObject question = (JSONObject) questions.get(index);
					String title = question.get("title").toString();
					JSONArray options = (JSONArray) question.get("options");
					String correctAnswer = question.get("correctAnswer").toString();
					questionsPanel.setQuestionLabel(title);
					questionsPanel.setOptionRadioButton(options);
					System.out.println("CorrectAns:" + correctAnswer.toString());
					quizModel.setCorrectAnswer(correctAnswer.toString());
					quizView.repaint();
					quizView.setLayout(new GridLayout(2, 1));
					quizView.getContentPane().add(questionsPanel);
					quizView.getContentPane().add(nextPanel);
					quizView.revalidate();
			}catch(NumberFormatException ex) {
				quizView.displayMessage("Index did not return an integer value");
				ex.printStackTrace();
			}catch(NullPointerException nE) {
				quizView.displayMessage("Please select an option");
				nE.printStackTrace();				
			}
		}

	}

	class GiveUpListener implements ActionListener{	
		public void actionPerformed(ActionEvent event) {
			try {
				boolean quit = quizModel.hasGivenUp();
				if(quit) {
					//change current panel and add a new one.
					quizView.getContentPane().removeAll();
					quizView.repaint();
					quizView.getContentPane().add(quitPanel);
					quizView.revalidate();
			}

			}catch(Exception error){
				quizView.displayMessage("Error has occurred");
				error.printStackTrace();
			}
		}

	}
	
	class SubmitListener implements ActionListener{	
		public void actionPerformed(ActionEvent event) {
			try {	
					int index = quizModel.getIndex();
					ButtonGroup group = questionsPanel.getButtonGroup();
					String selected = group.getSelection().getActionCommand();
					boolean isCorrect = quizModel.checkIfCorrect(index, selected);
					System.out.println("isCorrect"+isCorrect);
					boolean quizDone = quizModel.checkIfDone();
					System.out.println("quizDone"+quizDone);
					
				if(quizDone) {
					//change current panel and add a new one.
					System.out.println("Inside Submit Listener");
					quizView.getContentPane().removeAll();
					quizView.repaint();
					quizView.getContentPane().add(quizSubmitPanel);
					quizView.revalidate();
				} else {
					int numWrong = quizModel.getQuestions().size();
					quizView.displayMessage("You have answer " + numWrong + " questions incorrectly");
					index = quizModel.resetIndex();
					boolean isLastElement = quizModel.checkIsLastElement();
					if(isLastElement)
					{	nextPanel.next.setVisible(false);
						nextPanel.submit.setVisible(true);
					}
					else {
						nextPanel.next.setVisible(true);
						nextPanel.submit.setVisible(false);
					}
<<<<<<< Updated upstream
					group.clearSelection();
					questionsPanel.setQuestionLabel(quizModel.resetData());
					questionsPanel.setOptionRadioButton(quizModel.resetOptions());
					quizView.revalidatePanel(questionsPanel, nextPanel);
				}
=======
					
					group.clearSelection();
					quizView.getContentPane().removeAll();
					//Reset all info.
					JSONArray questions = quizModel.getQuestions();
					JSONObject question = (JSONObject) questions.get(index);
					String title = question.get("title").toString();
					JSONArray options = (JSONArray) question.get("options");
					String correctAnswer = question.get("correctAnswer").toString();
					questionsPanel.setQuestionLabel(title);
					questionsPanel.setOptionRadioButton(options);
					System.out.println("CorrectAns:" + correctAnswer.toString());
					quizModel.setCorrectAnswer(correctAnswer.toString());
					quizView.repaint();
					quizView.setLayout(new GridLayout(2, 1));
					quizView.getContentPane().add(questionsPanel);
					quizView.getContentPane().add(nextPanel);
					quizView.revalidate();	
					}
>>>>>>> Stashed changes

			}catch(Exception error){
				quizView.displayMessage("Please submit the quiz");
				error.printStackTrace();
			}
		}

	}
	

}
