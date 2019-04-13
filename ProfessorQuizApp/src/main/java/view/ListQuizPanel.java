package view;

import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import utilities.FileManager;

import javax.swing.GroupLayout.Alignment;

public class ListQuizPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JList<String> quizJList;
	JButton backButton;
	
	public ListQuizPanel() 
	{
		try {
			List<String> quizList;
			JLabel titleLabel = new JLabel("List Quiz !!!");
			titleLabel.setFont(new Font("Georgia", Font.BOLD, 16));
			titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			FileManager fm = FileManager.getInstance();
			quizList = fm.getQuizFileList();
			
			DefaultListModel<String> quizNameList = new DefaultListModel<>();
			for(int i=0;i<quizList.size();i++)
			{
				quizNameList.addElement(quizList.get(i));
			}
			
			quizJList = new JList<>(quizNameList);
			quizJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			
			backButton = new JButton("Go Back");
			backButton.setPreferredSize(new Dimension(120, 40));
			backButton.setMaximumSize(new Dimension(120, 40));
			backButton.setMinimumSize(new Dimension(120, 40));
			
			
			add(titleLabel);
			add(quizJList);
			add(backButton);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//this.setLayout(gl_panel);
	}	
	


	public JList<String> getQuizJList() {
		return quizJList;
	}


	public JButton getBackButton() {
		return backButton;
	}
	
}
