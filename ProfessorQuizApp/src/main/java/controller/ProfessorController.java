package controller;
import view.CreateQuizPanel;
import view.DashboardPanel;
import view.EditQuizPanel;
import view.ProfessorView;

public class ProfessorController {
	
	DashboardPanel dashboardPanel;
	CreateQuizPanel createQuizPanel;
	EditQuizPanel editQuizPanel;
	ProfessorView view;
	public ProfessorController() {
		view = new ProfessorView();
		dashboardPanel = new DashboardPanel();
		view.setPanel(dashboardPanel);
		dashboardPanel.getCreateQuizButton().addActionListener(e -> createButtonClicked());
		dashboardPanel.getEditQuizButton().addActionListener(e -> editButtonClicked());
		view.setVisible(true);
	}

	private void createButtonClicked() {
		System.out.println("create clicked");
		createQuizPanel = new CreateQuizPanel();
		view.remove(dashboardPanel);
		view.setPanel(createQuizPanel);

		view.invalidate();
		view.validate();
		view.repaint();

	}
	
	private void editButtonClicked() {
		editQuizPanel = new EditQuizPanel();
		view.remove(dashboardPanel);
		view.setPanel(editQuizPanel);
		editQuizPanel.getBackButton().addActionListener(e -> backButtonClicked());
		editQuizPanel.getNextButton().addActionListener(e -> nextButtonClicked());
		
		view.invalidate();
		view.validate();
		view.repaint();
	}
	
	private void backButtonClicked() {
		view.remove(editQuizPanel);
		view.setPanel(dashboardPanel);
		
		view.invalidate();
		view.validate();
		view.repaint();
	}
	
	private void nextButtonClicked() {
		System.out.println("Next button clicked");
	}
}
