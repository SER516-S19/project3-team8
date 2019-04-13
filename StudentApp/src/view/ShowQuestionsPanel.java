package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import org.json.simple.JSONArray;

/**
*
* @author Sajith Thattazhi
* @author Jainish
* @author Aditya
* @since 04/09/2019
*/

@SuppressWarnings("serial")
public class ShowQuestionsPanel extends JPanel {
	JRadioButton optionRadioButton1;
	JRadioButton optionRadioButton2;
	JRadioButton optionRadioButton3;
	JRadioButton optionRadioButton4;
	JTextArea questionLabel;
	ButtonGroup group;

	/**
	 * Creates a new panel to display the questions and their options.
	 */
	public ShowQuestionsPanel() {
		this.setLayout(new GridLayout(5, 1, 2, 10));
		optionRadioButton1 = new JRadioButton();
		optionRadioButton2 = new JRadioButton();
		optionRadioButton3 = new JRadioButton();
		optionRadioButton4 = new JRadioButton();
		questionLabel = new JTextArea();
		questionLabel.setWrapStyleWord(true);
		questionLabel.setLineWrap(true);
		questionLabel.setEditable(false);
		Color color = new Color(238, 238, 238); 
		questionLabel.setBackground(color);
		
		this.add(questionLabel);
		this.add(optionRadioButton1);
		this.add(optionRadioButton2);
		this.add(optionRadioButton3);
		this.add(optionRadioButton4);
	}

	/**
	 * Populates the Option Radio-buttons with the options of the question.
	 * @param optionsArray Contains all the options for the question.
	 */
	public void setOptionRadioButton(JSONArray optionsArray) {
		String option1 = optionsArray.get(0).toString();
		String option2 = optionsArray.get(1).toString();
		String option3 = optionsArray.get(2).toString();
		String option4 = optionsArray.get(3).toString();
		
		this.optionRadioButton1.setText(option1);
		this.optionRadioButton2.setText(option2);
		this.optionRadioButton3.setText(option3);
		this.optionRadioButton4.setText(option4);
		
		this.optionRadioButton1.setActionCommand(option1);
		this.optionRadioButton2.setActionCommand(option2);
		this.optionRadioButton3.setActionCommand(option3);
		this.optionRadioButton4.setActionCommand(option4);
		
		group = new ButtonGroup();
		group.add(optionRadioButton1);
		group.add(optionRadioButton2);
		group.add(optionRadioButton3);
		group.add(optionRadioButton4);
	}

	/**
	 * Populates the Question Label with the question.
	 * @param question Contains content of the question.
	 */
	public void setQuestionLabel(String question) {
		this.questionLabel.setText(question);
	}
	
	public ButtonGroup getButtonGroup(){
		return group;
	}
	
	public JTextArea getQuestionLabel() {
		return questionLabel;
	}
}
