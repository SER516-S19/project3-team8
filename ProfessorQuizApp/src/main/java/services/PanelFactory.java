/**
 * 
 */
package services;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.CreateQuizPanel;
import view.DashboardPanel;
import view.EditQuizPanel;
import view.PanelType;
import view.SaveQuizPanel;

/**
 * Factory class to produce different panels
 * 
 * @author ishansarangi
 *
 */
public class PanelFactory {
	/**
	 * Method which takes the panel type as argument and returns the
	 * generated panel
	 * 
	 * @param type
	 * @param listeners
	 * @return created panel with buttons associated with their respective listeners
	 */

	public static JPanel getPanel(PanelType type, ActionListener[] listeners) throws NullPointerException {
		switch (type) {
		case Dashboard:
			DashboardPanel dashboardPanel = new DashboardPanel();
			dashboardPanel.getCreateQuizButton().addActionListener(listeners[0]);
			dashboardPanel.getEditQuizButton().addActionListener(listeners[1]);
			return dashboardPanel;

		case CreateQuiz:
			CreateQuizPanel createQuizPanel = new CreateQuizPanel();
			return createQuizPanel;

		case EditQuiz:
			EditQuizPanel editQuizPanel = new EditQuizPanel();
			editQuizPanel.getBackButton().addActionListener(listeners[0]);
			editQuizPanel.getNextButton().addActionListener(listeners[1]);
			return editQuizPanel;

		case SaveQuiz:
			SaveQuizPanel saveQuizPanel = new SaveQuizPanel();
			saveQuizPanel.getSaveButton().addActionListener(listeners[0]);
			return saveQuizPanel;
		}

		throw new NullPointerException("No such panel was created");
	}
}
