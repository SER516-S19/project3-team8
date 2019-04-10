package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SaveQuizPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton saveButton;

	public SaveQuizPanel() 
	{
		
		JLabel titleLabel = new JLabel("Save !!!");
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);
		
		saveButton = new JButton("Save Quiz");
		saveButton.setPreferredSize(new Dimension(120, 40));
		saveButton.setMaximumSize(new Dimension(120, 40));
		saveButton.setMinimumSize(new Dimension(120, 40));
		add(saveButton);
		
	}
	
	public JButton getSaveButton() {
		return saveButton;
	}

}
