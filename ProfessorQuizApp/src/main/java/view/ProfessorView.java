package view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * This class is to set the initial frame
 * @author ishansarangi
 *
 */
public class ProfessorView extends JFrame {
	private static final long serialVersionUID = 1L;

	public ProfessorView() {
		setSize(new Dimension(500, 400));
		setMinimumSize(new Dimension(500, 400));
		getContentPane().setBounds(new Rectangle(10, 10, 10, 10));
		getContentPane().setMinimumSize(new Dimension(500, 400));
		JPanel content = new JPanel(new GridBagLayout());
        setContentPane(content);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		getContentPane().setLayout(groupLayout);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setPanel(JPanel panel) {
		getContentPane().add(panel);
	}
}