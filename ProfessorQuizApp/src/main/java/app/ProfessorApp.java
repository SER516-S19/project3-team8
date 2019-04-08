package app;

import javax.swing.SwingUtilities;

import controller.ProfessorController;


/**
 * Professor App
 * @author ishansarangi
 * @version 0.0.1
 *
 */
public class ProfessorApp {
	public static void main( String[] args ) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new ProfessorController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
