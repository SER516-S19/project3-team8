package app;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import controller.ProfessorController;
import utilities.FileManager;

/**
 * 
 * This is the main class for the Professor to create quiz
 * 
 * @author ishansarangi
 * @version 0.0.1
 */
public class ProfessorApp {
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					perormInitialSetup();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * This method prompts the user to select a location to save and retrieve
	 * quizzes
	 */
	private static void perormInitialSetup() {

		int userInput = JOptionPane.showOptionDialog(null, "Choose the folder to save the quizzes!!!",
				"Hello Professor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (userInput == JOptionPane.OK_OPTION) {
			showFileChooser();
		} else {
			System.exit(0);
		}
	}

	private static void showFileChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Choose location to save quizzes");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
			FileManager.getInstance().setQuizDirectoryPath(chooser.getSelectedFile());
			new ProfessorController();

		} else {
			System.out.println("No Selection ");
			System.exit(0);
		}
	}

}
