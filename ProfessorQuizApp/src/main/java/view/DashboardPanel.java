package view;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

/**
 * This class is to show the initial view of the professor
 * 
 * @author ishansarangi
 *
 */
public class DashboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JButton createQuizButton;
	JButton editQuizButton;

	public DashboardPanel() {

		JLabel titleLabel = new JLabel("Welcome Professor !!!");
		titleLabel.setBounds(109, 38, 202, 27);
		titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		createQuizButton = new JButton("Create Quiz");
		createQuizButton.setBounds(66, 141, 120, 40);
		createQuizButton.setPreferredSize(new Dimension(120, 40));
		createQuizButton.setMaximumSize(new Dimension(120, 40));
		createQuizButton.setMinimumSize(new Dimension(120, 40));
		
		editQuizButton = new JButton("List Quiz");
		editQuizButton.setBounds(244, 141, 117, 40);
		editQuizButton.setPreferredSize(new Dimension(120, 40));
		editQuizButton.setMaximumSize(new Dimension(120, 40));
		editQuizButton.setMinimumSize(new Dimension(120, 40));
		setLayout(null);
		add(createQuizButton);
		add(editQuizButton);
		add(titleLabel);
	}

	public JButton getCreateQuizButton() {
		return createQuizButton;
	}

	public JButton getEditQuizButton() {
		return editQuizButton;
	}
}
