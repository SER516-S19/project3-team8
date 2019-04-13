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

import org.hamcrest.core.IsNull;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.Question;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class CreateQuizPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private static Map<String,ArrayList<Question>> quizMap = new HashMap<String,ArrayList<Question>>();
	private static JTextField quizNameTextField,answerATextField,answerBTextField;
	private static JTextField answerCTextField,answerDTextField;
	private static JTextArea questionTextArea;
	private static JButton addQuestionButton, cancelButton,submitQuizButton;
	private static ButtonGroup group;
	
	public JButton getSubmitQuizButton() {
		return submitQuizButton;
	}

	public CreateQuizPanel() {
		
		JLabel titleLabel = new JLabel("Create Quiz !!!");
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		submitQuizButton = new JButton("Submit Quiz");
		submitQuizButton.setPreferredSize(new Dimension(120, 40));
		submitQuizButton.setMaximumSize(new Dimension(86, 29));
		submitQuizButton.setMinimumSize(new Dimension(86, 29));

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextAndSelection();
				clearQuizName();
			}
		});
		quizNameTextField = new JTextField();
		quizNameTextField.setColumns(10);

		JLabel quizLabel = new JLabel("Quiz Name");

		JLabel questionLabel = new JLabel("Question");

		JRadioButton answerARadioButton = new JRadioButton("A");
		answerARadioButton.setActionCommand("A");
		JRadioButton answerBRadioButton = new JRadioButton("B");
		answerBRadioButton.setActionCommand("B");
		JRadioButton answerCRadioButton = new JRadioButton("C");
		answerCRadioButton.setActionCommand("C");
		JRadioButton answerDRadioButton = new JRadioButton("D");
		answerDRadioButton.setActionCommand("D");
		
			group = new ButtonGroup();
		    group.add(answerARadioButton);
		    group.add(answerBRadioButton);
		    group.add(answerCRadioButton);
		    group.add(answerDRadioButton);
		    

		answerATextField = new JTextField();
		answerATextField.setColumns(10);

		questionTextArea = new JTextArea();

		answerBTextField = new JTextField();
		answerBTextField.setColumns(10);

		answerCTextField = new JTextField();
		answerCTextField.setColumns(10);

		answerDTextField = new JTextField();
		answerDTextField.setColumns(10);

		JLabel correctAnswerLabel = new JLabel("(Select the correct answer choice)");
		
		addQuestionButton = new JButton("Add Question");
		addQuestionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkEntryExists()) {
					getQuizQuestions();
					clearTextAndSelection();
				}
			}
		});

		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(questionLabel)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(28)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(answerBRadioButton)
												.addComponent(answerARadioButton)
												.addComponent(answerCRadioButton)
												.addComponent(answerDRadioButton))))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(quizLabel)
													.addGap(18)
													.addComponent(quizNameTextField, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(39)
													.addComponent(questionTextArea, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(answerCTextField)
												.addComponent(answerATextField, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
												.addComponent(answerBTextField)
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(6)
													.addComponent(answerDTextField, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))))))
								.addComponent(correctAnswerLabel, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(58)
							.addComponent(cancelButton)
							.addGap(18)
							.addComponent(addQuestionButton)
							.addGap(24)
							.addComponent(submitQuizButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(163)
							.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(quizNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(quizLabel))
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(questionLabel)
						.addComponent(questionTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(correctAnswerLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(answerARadioButton)
						.addComponent(answerATextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(answerBTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(answerBRadioButton))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(answerCRadioButton)
						.addComponent(answerCTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(answerDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(answerDRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitQuizButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(addQuestionButton))
					.addGap(20))
		);
		this.setLayout(gl_panel);

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
