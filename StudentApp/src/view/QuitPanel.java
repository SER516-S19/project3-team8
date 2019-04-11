package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Panel displayed when the user quits
 * @author Aditya Samant
 * @since 04/06/2019
 * */
@SuppressWarnings("serial")
public class QuitPanel extends JPanel {
	JLabel quitMsg = new JLabel("Better Luck Next Time");
	
	QuitPanel(){
		this.add(quitMsg); 
		
	}
}
