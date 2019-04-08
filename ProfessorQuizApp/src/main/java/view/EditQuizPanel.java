package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

public class EditQuizPanel extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton backButton;
	JButton nextButton;
	
	public EditQuizPanel() {
		JLabel titleLabel = new JLabel("Edit Quiz");
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);
		
		backButton = new JButton("Go Back");
		backButton.setPreferredSize(new Dimension(120, 40));
		backButton.setMaximumSize(new Dimension(120, 40));
		backButton.setMinimumSize(new Dimension(120, 40));
		
		nextButton = new JButton("Next");
		nextButton.setPreferredSize(new Dimension(120, 40));
		nextButton.setMaximumSize(new Dimension(120, 40));
		nextButton.setMinimumSize(new Dimension(120, 40));
		
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(66)
					.addComponent(backButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(backButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		this.setLayout(gl_panel);

	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public JButton getNextButton() {
		return nextButton;
	}
}
