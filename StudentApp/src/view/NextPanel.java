package view;

import javax.swing.JButton;
import javax.swing.JPanel;


import java.awt.event.ActionListener;

/**
 * 
 * @author Aditya Samant
 * @date 4/06/2019
 * @since 4/03/2019
 * */
@SuppressWarnings("serial")
public class NextPanel extends JPanel {
		
	//This is a modification
	public JButton next = new JButton("Next");
	JButton quit = new JButton("Give Up");
	public JButton submit = new JButton("Submit Quiz");
	
	
	public void addNextListener(ActionListener nextListener) {
		next.addActionListener(nextListener);
	}
	
	public void addGiveUpListener(ActionListener giveUpListener) {
		quit.addActionListener(giveUpListener);
	}
	
	public void addSubmitListener(ActionListener submitListener) {
		submit.addActionListener(submitListener);
	}
	
	NextPanel(){
		this.setVisible(true);
		this.add(next);
		this.add(quit);
		this.add(submit);
		submit.setVisible(false);
		
		
	}
}
