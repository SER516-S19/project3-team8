package view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.*;

public class QuizListView extends JFrame {
	String[] quizes = new String[] {"Quiz-1", "Quiz-2",
            "Quiz-3", "Quiz-4"};

    private JComboBox<String> quizList = new JComboBox<String>(quizes);
	private JButton okBtn = new JButton("OK");
    int x, y;
    public QuizListView() {
    	JPanel contentPane = new JPanel();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(490, 50, 900, 950);
        setTitle("Professor Window For Quiz Application");
        setResizable(false);
        contentPane.setEnabled(false);
        contentPane.setBackground(new Color(211, 211, 211));
        contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setUndecorated(true);
        quizList.setVisible(true);
        contentPane.add(quizList);
        
        okBtn.setEnabled(false);
        contentPane.add(okBtn);

        quizList.setFont(new Font("Comic sense", Font.BOLD, 30));
        quizList.setBounds(238, 436, 305, 49);
        quizList.setForeground(new Color(255, 255, 255));
        quizList.setBackground(new Color(0, 181, 204));
        quizList.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        okBtn.setFont(new Font("Comic sense", Font.BOLD, 24));
        okBtn.setBounds(238, 550, 305, 49);
        okBtn.setForeground(Color.WHITE);
        okBtn.setBackground(new Color(0, 181, 204));
        okBtn.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        okBtn.setEnabled(true);
        contentPane.add(quizList);

        JLabel welcomeLabel = new JLabel("Hello Professor!");
        welcomeLabel.setBounds(150, 239, 672, 80);
        welcomeLabel.setFont(new Font("Monospace", Font.BOLD, 70));
        welcomeLabel.setForeground(new Color(240, 248, 255));
        contentPane.add(welcomeLabel);
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBackground(new Color(37, 116, 169));
        panel.setBounds(0, 0, 900, 43);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel closeBtn = new JLabel("X");
        closeBtn.setForeground(Color.WHITE);
        closeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();
            }
        });
        closeBtn.setFont(new Font("Comic sense", Font.BOLD, 30));
        closeBtn.setHorizontalAlignment(SwingConstants.CENTER);
        closeBtn.setBounds(846, 0, 54, 43);
        panel.add(closeBtn);

        JLabel header = new JLabel("Quiz Application - Professor Window");
        header.setFont(new Font("Inconsolata", Font.BOLD, 16));
        header.setForeground(Color.WHITE);
        header.setBounds(0, 0, 525, 43);
        panel.add(header);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    QuizListView frame = new QuizListView();
                    frame.setVisible(true);                  
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
