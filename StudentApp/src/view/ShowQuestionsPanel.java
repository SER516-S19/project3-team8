package view;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import model.StudentModel;

/**
*
* @author Sajith Thattazhi
* @since 04/09/2019
*/
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

		StudentModel studentModel = new StudentModel();
		JSONArray questions = studentModel.getQuestions();
		int index = studentModel.getIndex();

		JSONObject question = (JSONObject) questions.get(index);
		JSONObject title = (JSONObject) question.get("title");
		JSONArray options = (JSONArray) question.get("options");
		JSONObject correctAnswer = (JSONObject) question.get("correctAnswer");

		questionLabel.setText(title.toString());

		optionRadioButton1.setText(((JSONObject)options.get(0)).toString());
		optionRadioButton2.setText(((JSONObject)options.get(1)).toString());
		optionRadioButton3.setText(((JSONObject)options.get(2)).toString());
		optionRadioButton4.setText(((JSONObject)options.get(3)).toString());
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
}
