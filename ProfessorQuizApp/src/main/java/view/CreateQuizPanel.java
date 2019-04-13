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
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Question;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 * 
 * @author alshasamantaray, ishansarangi
 *
 */
public class CreateQuizPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Map<String,ArrayList<Question>> quizMap = new HashMap<String,ArrayList<Question>>();
	private JTextField quizNameTextField,answerATextField,answerBTextField;
	private  JTextField answerCTextField,answerDTextField;
	private  JTextArea questionTextArea;
	private  JButton addQuestionButton, cancelButton,submitQuizButton;
	private  ButtonGroup group;
	
	public JButton getSubmitQuizButton() {
		return submitQuizButton;
	}

	public CreateQuizPanel() {
		setPreferredSize(new Dimension(500, 500));
		setMinimumSize(new Dimension(100, 100));
		
		JLabel titleLabel = new JLabel("Create Quiz !!!");
		titleLabel.setBounds(173, 6, 202, 27);
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		submitQuizButton = new JButton("Submit Quiz");
		submitQuizButton.setBounds(326, 306, 120, 40);
		submitQuizButton.setPreferredSize(new Dimension(120, 40));
		submitQuizButton.setMaximumSize(new Dimension(86, 29));
		submitQuizButton.setMinimumSize(new Dimension(86, 29));

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(68, 309, 86, 34);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextAndSelection();
				clearQuizName();
			}
		});
		quizNameTextField = new JTextField();
		quizNameTextField.setBounds(173, 45, 271, 26);
		quizNameTextField.setColumns(10);

		JLabel quizLabel = new JLabel("Quiz Name");
		quizLabel.setBounds(86, 50, 69, 16);

		JLabel questionLabel = new JLabel("Question");
		questionLabel.setBounds(10, 94, 57, 16);

		JRadioButton answerARadioButton = new JRadioButton("A");
		answerARadioButton.setBounds(38, 151, 41, 23);
		answerARadioButton.setActionCommand("A");
		JRadioButton answerBRadioButton = new JRadioButton("B");
		answerBRadioButton.setBounds(38, 180, 39, 23);
		answerBRadioButton.setActionCommand("B");
		JRadioButton answerCRadioButton = new JRadioButton("C");
		answerCRadioButton.setBounds(38, 218, 41, 23);
		answerCRadioButton.setActionCommand("C");
		JRadioButton answerDRadioButton = new JRadioButton("D");
		answerDRadioButton.setBounds(38, 250, 42, 23);
		answerDRadioButton.setActionCommand("D");
		
			group = new ButtonGroup();
		    group.add(answerARadioButton);
		    group.add(answerBRadioButton);
		    group.add(answerCRadioButton);
		    group.add(answerDRadioButton);
		    

		answerATextField = new JTextField();
		answerATextField.setBounds(98, 148, 341, 26);
		answerATextField.setColumns(10);

		questionTextArea = new JTextArea();
		questionTextArea.setBounds(125, 94, 348, 16);

		answerBTextField = new JTextField();
		answerBTextField.setBounds(98, 180, 341, 26);
		answerBTextField.setColumns(10);

		answerCTextField = new JTextField();
		answerCTextField.setBounds(98, 215, 341, 26);
		answerCTextField.setColumns(10);

		answerDTextField = new JTextField();
		answerDTextField.setBounds(104, 247, 335, 26);
		answerDTextField.setColumns(10);

		JLabel correctAnswerLabel = new JLabel("(Select the correct answer choice)");
		correctAnswerLabel.setBounds(10, 120, 335, 16);
		
		addQuestionButton = new JButton("Add Question");
		addQuestionButton.setBounds(172, 312, 130, 29);
		addQuestionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkEntryExists()) {
					getQuizQuestions();
					clearTextAndSelection();
				}
			}
		});
		setLayout(null);
		add(questionLabel);
		add(answerBRadioButton);
		add(answerARadioButton);
		add(answerCRadioButton);
		add(answerDRadioButton);
		add(quizLabel);
		add(quizNameTextField);
		add(questionTextArea);
		add(answerCTextField);
		add(answerATextField);
		add(answerBTextField);
		add(answerDTextField);
		add(correctAnswerLabel);
		add(cancelButton);
		add(addQuestionButton);
		add(submitQuizButton);
		add(titleLabel);

	}
	
	public void getQuizQuestions() {
		Question questions = new Question();
		questions.setQuestionTitle(getQuestion());
		questions.setOptions(getAnswerOptions());
		questions.setCorrectAnswer(getCorrectAnswerChoice());
		setQuizQuestions(questions);
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
	
	public void setQuizQuestions(Question question) {
		ArrayList<Question> questionList = new ArrayList<Question>();
		if (quizMap.size() > 0 && quizMap.get("questions") != null) {
			questionList = quizMap.get("questions");
			questionList.add(question);
			quizMap.put("questions", questionList);
		} else {
			questionList.add(question);
			quizMap.put("questions", questionList);
		}
	}

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
		String answerChoice =  null;
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
		if(getQuizName().isEmpty())
			JOptionPane.showMessageDialog(null, "Please enter a quiz name");
		else if(getQuestion().isEmpty())
			JOptionPane.showMessageDialog(null, "Please enter a valid question");
		else if(answerATextField.getText().isEmpty() || answerBTextField.getText().isEmpty() ||
				answerCTextField.getText().isEmpty()|| answerDTextField.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Please enter all answer choices");
		else if(group.getSelection()== null)
			JOptionPane.showMessageDialog(null, "Please select the correct answer choices");
		else 
			result = true;
		return result;
	}
}
