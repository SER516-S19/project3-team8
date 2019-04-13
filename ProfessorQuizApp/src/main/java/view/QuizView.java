package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class QuizView extends JFrame {
    private JLabel QuizName = new JLabel();

    public QuizView() {

        JPanel contentPane;
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(25, 25, 1025, 500);

        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(5, 5, 1, 834);
        contentPane.add(layeredPane);

        QuizName.setFont(new Font("Courier", Font.BOLD, 40));
        QuizName.setBounds(310, 50, 600, 80);
        QuizName.setForeground(Color.BLACK);
        contentPane.add(QuizName);
    }
}
