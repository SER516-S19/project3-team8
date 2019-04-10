package view;

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
	* Creates new form ShowQuestionsPanel
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

	private void optionRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if(optionRadioButton1.isSelected())
		{
			optionRadioButton2.setSelected(false);
			optionRadioButton3.setSelected(false);
			optionRadioButton4.setSelected(false);
		}
	}

	private void optionRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if(optionRadioButton2.isSelected())
		{
			optionRadioButton1.setSelected(false);
			optionRadioButton3.setSelected(false);
			optionRadioButton4.setSelected(false);
		}
	}

	private void optionRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if(optionRadioButton3.isSelected())
		{
			optionRadioButton1.setSelected(false);
			optionRadioButton2.setSelected(false);
			optionRadioButton4.setSelected(false);
		}
	}

	private void optionRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		if(optionRadioButton4.isSelected())
		{
			optionRadioButton1.setSelected(false);
			optionRadioButton2.setSelected(false);
			optionRadioButton3.setSelected(false);
		}
	}
}
