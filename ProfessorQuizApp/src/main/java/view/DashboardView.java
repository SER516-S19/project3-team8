package view;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Font;

public class DashboardView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton createQuizButton;
	
	JButton editQuizButton;
	
	public DashboardView() {
		setSize(new Dimension(423, 300));
		setMinimumSize(new Dimension(400, 300));
		getContentPane().setBounds(new Rectangle(10, 10, 10, 10));
		getContentPane().setMinimumSize(new Dimension(2000, 2000));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		getContentPane().setLayout(groupLayout);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
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
		
		GroupLayout gl_panel = new GroupLayout(panel);
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
		panel.setLayout(gl_panel);

	}
	
	public JButton getCreateQuizButton() {
		return createQuizButton;
	}

	public JButton getEditQuizButton() {
		return editQuizButton;
	}

}
