package team8.ProfessorQuizApp;

import javax.swing.SwingUtilities;

import controller.DashboardController;


/**
 * Professor App
 * @author ishansarangi
 * @version 0.0.1
 *
 */
public class App {
	public static void main( String[] args ) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new DashboardController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
