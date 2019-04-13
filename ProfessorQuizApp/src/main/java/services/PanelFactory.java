package services;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.CreateQuizPanel;
import view.DashboardPanel;
import view.ListQuizPanel;
import view.PanelType;

/**
 * Factory class to create different panels
 * 
 * @author ishansarangi
 */
public class PanelFactory {
	/**
	 * Method which takes the panel type as argument and returns the generated panel
	 * 
	 * @param type      The type of the panel to be created
	 * @param listeners Action listeners
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
			createQuizPanel.getcancelButton().addActionListener(listeners[0]);
			return createQuizPanel;

		case ListQuiz:
			ListQuizPanel listQuizPanel = new ListQuizPanel();
			listQuizPanel.getBackButton().addActionListener(listeners[0]);
			return listQuizPanel;
		}
		throw new NullPointerException("No such panel was created");
	}

}
