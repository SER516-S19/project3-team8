package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

public class CreateQuizPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JButton submitQuizButton;
	
	public JButton getSubmitQuizButton() {
		return submitQuizButton;
	}

	public CreateQuizPanel() 
	{
		JLabel titleLabel = new JLabel("Create Quiz !!!");
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		submitQuizButton = new JButton("Submit Quiz");
		submitQuizButton.setPreferredSize(new Dimension(120, 40));
		submitQuizButton.setMaximumSize(new Dimension(120, 40));
		submitQuizButton.setMinimumSize(new Dimension(120, 40));
		
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(66)
						.addComponent(submitQuizButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(109)
						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(38)
						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGap(76)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(submitQuizButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							))
			);
			this.setLayout(gl_panel);

	}	
}
