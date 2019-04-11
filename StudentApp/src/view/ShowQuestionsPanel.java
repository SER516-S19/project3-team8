package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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
	JLabel questionLabel;

	/**
	 * Creates a new panel to display the questions and their options.
	 */
	public ShowQuestionsPanel() {
		optionRadioButton1 = new JRadioButton();
		optionRadioButton2 = new JRadioButton();
		optionRadioButton3 = new JRadioButton();
		optionRadioButton4 = new JRadioButton();
		questionLabel = new JLabel();
		
		this.add(questionLabel);
		this.add(optionRadioButton1);
		this.add(optionRadioButton2);
		this.add(optionRadioButton3);
		this.add(optionRadioButton4);
	}

	public void setOptionRadioButton(JSONArray optionsArray) {
		String option1 = optionsArray.get(0).toString();
		String option2 = optionsArray.get(1).toString();
		String option3 = optionsArray.get(2).toString();
		String option4 = optionsArray.get(3).toString();
		this.optionRadioButton1.setText(option1);
		this.optionRadioButton2.setText(option2);
		this.optionRadioButton3.setText(option3);
		this.optionRadioButton4.setText(option4);
		ButtonGroup group = new ButtonGroup();
		group.add(optionRadioButton1);
		group.add(optionRadioButton2);
		group.add(optionRadioButton3);
		group.add(optionRadioButton4);
	}


	public void setQuestionLabel(String questionLabel) {
		//String title = questionLabel.toString();
		this.questionLabel.setText(questionLabel);
	}

	public javax.swing.JRadioButton getOptionRadioButton1() {
		return optionRadioButton1;
	}

	public javax.swing.JRadioButton getOptionRadioButton2() {
		return optionRadioButton2;
	}

	public javax.swing.JRadioButton getOptionRadioButton3() {
		return optionRadioButton3;
	}

	public javax.swing.JRadioButton getOptionRadioButton4() {
		return optionRadioButton4;
	}

	public javax.swing.JLabel getQuestionLabel() {
		return questionLabel;
	}
	
	
	

	
	
}
