package view;

import javax.swing.JFrame;

/**
 * 
 * 
 * */
@SuppressWarnings("serial")
public class StudentView extends JFrame{
				private NextPanel nextPanel = new NextPanel();
				private QuitPanel quitPanel = new QuitPanel();
				StudentView(){
					this.setSize(500,400);
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					this.add(nextPanel);
					this.setVisible(true);
				}	
				
				public NextPanel getNextPanel() {
					return nextPanel;
				}
				public QuitPanel getQuitPanel() {
					return quitPanel;
				}
}
		
