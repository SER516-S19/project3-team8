package view;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CreateQuizPanel extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CreateQuizPanel() 
	{
		JLabel titleLabel = new JLabel("Create Quiz !!!");
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);
	}	
}
