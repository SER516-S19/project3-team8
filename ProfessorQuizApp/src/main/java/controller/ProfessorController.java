package controller;
import view.CreateQuizPanel;
import view.DashboardPanel;
import view.ProfessorView;

public class ProfessorController {
	
	DashboardPanel dashboardPanel;
	CreateQuizPanel createQuizPanel;
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
		System.out.println("edit clicked");
	}
}
