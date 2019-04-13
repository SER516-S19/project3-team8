package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ProfessorView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorView() {
		setSize(new Dimension(400, 400));
		setMinimumSize(new Dimension(400, 300));
		getContentPane().setBounds(new Rectangle(10, 10, 10, 10));
		getContentPane().setMinimumSize(new Dimension(2000, 2000));
		setLocationRelativeTo(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		getContentPane().setLayout(groupLayout);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void setPanel(JPanel panel) {
		getContentPane().add(panel);
	}
}