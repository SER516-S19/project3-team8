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
	private int index = 0; //starting index in any quiz with at least one question.	
	//This is a modification
	JButton next = new JButton("Next");
	JButton quit = new JButton("Give Up");
	
	public void addNextListener(ActionListener nextListener) {
		next.addActionListener(nextListener);
	}
	
	public void addGiveUpListener(ActionListener giveUpListener) {
		quit.addActionListener(giveUpListener);
	}
	
	public int getIndex() {
		return index;
	}
	NextPanel(){
		this.setVisible(true);
		this.add(next);
		this.add(quit);
	}
}
