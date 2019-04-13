package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Question;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 * 
 * @author alshasamantaray, ishansarangi
 *
 */
public class CreateQuizPanel extends JPanel {

	private static final long serialVersionUID = 1L;
//	private Map<String, ArrayList<Question>> quizMap = new HashMap<String, ArrayList<Question>>();
	private JTextField quizNameTextField, answerATextField, answerBTextField;
	private JTextField answerCTextField, answerDTextField;
	private JTextArea questionTextArea;
	private JButton addQuestionButton, cancelButton, submitQuizButton;
	private ButtonGroup group;

	public JButton getSubmitQuizButton() {
		return submitQuizButton;
	}

	public JButton getaddQuestionButton() {
		return addQuestionButton;
	}

	public JButton getcancelButton() {
		return cancelButton;
	}

//	public Map<String, ArrayList<Question>> getQuizQuestionDetails(){
//		return quizMap;
//	}
	
	public CreateQuizPanel() {
		setPreferredSize(new Dimension(500, 500));
		setMinimumSize(new Dimension(100, 100));

		group = new ButtonGroup();
		setLayout(null);

		JLabel titleLabel = new JLabel("Create Quiz !!!");
		titleLabel.setBounds(166, 0, 117, 22);
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);

		JLabel quizLabel = new JLabel("Quiz Name");
		quizLabel.setBounds(92, 32, 69, 16);
		add(quizLabel);
		quizNameTextField = new JTextField();
		quizNameTextField.setBounds(166, 27, 282, 26);
		quizNameTextField.setColumns(10);
		add(quizNameTextField);

		JLabel questionLabel = new JLabel("Question");
		questionLabel.setBounds(0, 58, 57, 16);
		add(questionLabel);

		questionTextArea = new JTextArea();
		questionTextArea.setBounds(92, 58, 356, 16);
		add(questionTextArea);

		JLabel correctAnswerLabel = new JLabel("(Select the correct answer choice)");
		correctAnswerLabel.setBounds(0, 79, 210, 16);
		add(correctAnswerLabel);

		JRadioButton answerARadioButton = new JRadioButton("A");
		answerARadioButton.setBounds(46, 103, 41, 23);
		answerARadioButton.setActionCommand("A");
		group.add(answerARadioButton);
		add(answerARadioButton);

		answerATextField = new JTextField();
		answerATextField.setBounds(92, 100, 356, 26);
		answerATextField.setColumns(10);
		add(answerATextField);
		JRadioButton answerBRadioButton = new JRadioButton("B");
		answerBRadioButton.setBounds(48, 131, 39, 23);
		answerBRadioButton.setActionCommand("B");
		group.add(answerBRadioButton);
		add(answerBRadioButton);

		answerBTextField = new JTextField();
		answerBTextField.setBounds(92, 131, 356, 26);
		answerBTextField.setColumns(10);
		add(answerBTextField);
		JRadioButton answerCRadioButton = new JRadioButton("C");
		answerCRadioButton.setBounds(46, 165, 41, 23);
		answerCRadioButton.setActionCommand("C");
		group.add(answerCRadioButton);
		add(answerCRadioButton);

		answerCTextField = new JTextField();
		answerCTextField.setBounds(92, 162, 356, 26);
		answerCTextField.setColumns(10);
		add(answerCTextField);
		JRadioButton answerDRadioButton = new JRadioButton("D");
		answerDRadioButton.setBounds(45, 196, 42, 23);
		answerDRadioButton.setActionCommand("D");
		group.add(answerDRadioButton);
		add(answerDRadioButton);

		answerDTextField = new JTextField();
		answerDTextField.setBounds(92, 193, 356, 26);
		answerDTextField.setColumns(10);
		add(answerDTextField);

		addQuestionButton = new JButton("Add Question");
		addQuestionButton.setBounds(166, 262, 130, 29);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(62, 262, 86, 29);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextAndSelection();
				clearQuizName();
			}
		});
		add(cancelButton);
		add(addQuestionButton);

		submitQuizButton = new JButton("Submit Quiz");
		submitQuizButton.setBounds(301, 257, 120, 40);
		submitQuizButton.setPreferredSize(new Dimension(120, 40));
		submitQuizButton.setMaximumSize(new Dimension(86, 29));
		submitQuizButton.setMinimumSize(new Dimension(86, 29));
		add(submitQuizButton);

	}

	public Question getQuizQuestions() {
		Question questions = new Question();
		questions.setQuestionTitle(getQuestion());
		questions.setOptions(getAnswerOptions());
		questions.setCorrectAnswer(getCorrectAnswerChoice());
		return questions;
//		setQuizQuestions(questions);
	}

	public void clearTextAndSelection() {
		questionTextArea.setText("");
		answerATextField.setText("");
		answerBTextField.setText("");
		answerCTextField.setText("");
		answerDTextField.setText("");
		group.clearSelection();
	}

	public void clearQuizName() {
		quizNameTextField.setText("");
	}

//	public void setQuizQuestions(Question question) {
//		ArrayList<Question> questionList = new ArrayList<Question>();
//		if (quizMap.size() > 0 && quizMap.get("questions") != null) {
//			questionList = quizMap.get("questions");
//			questionList.add(question);
//			quizMap.put("questions", questionList);
//		} else {
//			questionList.add(question);
//			quizMap.put("questions", questionList);
//		}
//	}

	public String getQuizName() {
		return quizNameTextField.getText();
	}

	public String getQuestion() {
		return questionTextArea.getText();
	}

	public ArrayList<String> getAnswerOptions() {
		ArrayList<String> options = new ArrayList<String>();
		options.add(answerATextField.getText());
		options.add(answerBTextField.getText());
		options.add(answerCTextField.getText());
		options.add(answerDTextField.getText());
		return options;
	}

	public String getCorrectAnswerChoice() {
		String answerChoice = null;
		ButtonModel model = group.getSelection();
		if (model.getActionCommand().equals("A"))
			answerChoice = answerATextField.getText();
		else if (model.getActionCommand().equals("B"))
			answerChoice = answerBTextField.getText();
		else if (model.getActionCommand().equals("C"))
			answerChoice = answerCTextField.getText();
		else if (model.getActionCommand().equals("D"))
			answerChoice = answerDTextField.getText();
		return answerChoice;
	}

	public boolean checkEntryExists() {
		boolean result = false;
		if (getQuizName().isEmpty())
			JOptionPane.showMessageDialog(null, "Please enter a quiz name");
		else if (getQuestion().isEmpty())
			JOptionPane.showMessageDialog(null, "Please enter a valid question");
		else if (answerATextField.getText().isEmpty() || answerBTextField.getText().isEmpty()
				|| answerCTextField.getText().isEmpty() || answerDTextField.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Please enter all answer choices");
		else if (group.getSelection() == null)
			JOptionPane.showMessageDialog(null, "Please select the correct answer choices");
		else
			result = true;
		return result;
	}
}
