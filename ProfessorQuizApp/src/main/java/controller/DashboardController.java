package controller;
import view.DashboardView;

public class DashboardController {
	
	public DashboardController() {
		DashboardView view = new DashboardView();
		view.setVisible(true);
		view.getCreateQuizButton().addActionListener(e -> createButtonClicked());
		view.getEditQuizButton().addActionListener(e -> editButtonClkicked());

	}

	private void createButtonClicked() {
		System.out.println("create clicked");
	}
	private void editButtonClkicked() {
		System.out.println("edit clicked");
	}
}
