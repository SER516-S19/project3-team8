package view;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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

	private javax.swing.JRadioButton optionRadioButton1;
	private javax.swing.JRadioButton optionRadioButton2;
	private javax.swing.JRadioButton optionRadioButton3;
	private javax.swing.JRadioButton optionRadioButton4;
	private javax.swing.JLabel questionLabel;

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
	
	/**
	 * Unselects all other radio-buttons when Option 1 is selected
	 * @param event Selection of optionRadioButton1
	 */
	private void optionRadioButton1Selected(ActionEvent event) {
		if(optionRadioButton1.isSelected())
		{
			optionRadioButton2.setSelected(false);
			optionRadioButton3.setSelected(false);
			optionRadioButton4.setSelected(false);
		}
	}

	/**
	 * Unselects all other radio-buttons when Option 2 is selected
	 * @param event Selection of optionRadioButton2
	 */
	private void optionRadioButton2Selected(ActionEvent event) {
		if(optionRadioButton2.isSelected())
		{
			optionRadioButton1.setSelected(false);
			optionRadioButton3.setSelected(false);
			optionRadioButton4.setSelected(false);
		}
	}

	/**
	 * Unselects all other radio-buttons when Option 3 is selected
	 * @param event Selection of optionRadioButton3
	 */
	private void optionRadioButton3Selected(ActionEvent event) {
		if(optionRadioButton3.isSelected())
		{
			optionRadioButton1.setSelected(false);
			optionRadioButton2.setSelected(false);
			optionRadioButton4.setSelected(false);
		}
	}

	/**
	 * Unselects all other radio-buttons when Option 4 is selected
	 * @param event Selection of optionRadioButton4
	 */
	private void optionRadioButton4ActionPerformed(ActionEvent event) {
		if(optionRadioButton4.isSelected())
		{
			optionRadioButton1.setSelected(false);
			optionRadioButton2.setSelected(false);
			optionRadioButton3.setSelected(false);
		}
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
