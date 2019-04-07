package view;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;

/**
 * 
 * @author Aditya Samant
 * @date 4/06/2019
 * @since 4/03/2019
 * */
public class QuizPanel extends JPanel {
	private int index = 0; //starting index in any quiz with at least one question.	
	
	JButton next = new JButton("Next");
	JButton quit = new JButton("Give Up");
	
	public void addNextListener(ActionListener listener) {
		next.addActionListener(listener);
	}
	
	public void addGiveUpListener(ActionListener listener) {
		quit.addActionListener(listener);
	}
	public void setNextIndex(int next) {
		index = next;
	}
	public int getIndex() {
		return index;
	}
	QuizPanel(){
		this.setVisible(false);
		this.add(next);
		this.add(quit);
	}
}
