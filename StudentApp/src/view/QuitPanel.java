package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel displayed when the user quits
 * @author Aditya Samant
 * @since 04/06/2019
 * */
public class QuitPanel extends JPanel {
	JTextField quitMsg = new JTextField("Better Luck Next Time");
	
	QuitPanel(){
		this.setVisible(false);
		this.add(quitMsg);
	}
}
