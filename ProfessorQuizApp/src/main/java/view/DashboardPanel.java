package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

public class DashboardPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JButton createQuizButton;
	JButton editQuizButton;
	
	public DashboardPanel() 
	{
		
		JLabel titleLabel = new JLabel("Welcome Professor !!!");
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		createQuizButton = new JButton("Create Quiz");
		createQuizButton.setPreferredSize(new Dimension(120, 40));
		createQuizButton.setMaximumSize(new Dimension(120, 40));
		createQuizButton.setMinimumSize(new Dimension(120, 40));
		
		editQuizButton = new JButton("Edit Quiz");
		editQuizButton.setPreferredSize(new Dimension(120, 40));
		editQuizButton.setMaximumSize(new Dimension(120, 40));
		editQuizButton.setMinimumSize(new Dimension(120, 40));
		
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(66)
					.addComponent(createQuizButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(editQuizButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(createQuizButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editQuizButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		this.setLayout(gl_panel);

	}	
	
	
	public JButton getCreateQuizButton() {
		return createQuizButton;
	}

	public JButton getEditQuizButton() {
		return editQuizButton;
	}
}
