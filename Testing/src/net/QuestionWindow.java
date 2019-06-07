package net;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionWindow extends JFrame {
    private static int numOfAnswers = 0;
    private static int numOfRightAnswers = 0;

    public QuestionWindow(Question question) {
        setLayout(null);
        int width = question.getText().length() * 6 + 50;
        setTitle(question.getText().split("\\.")[0]);
        setSize(width, 400);
        JLabel text = new JLabel(question.getText().split("\\.")[1]);
        JButton first = new JButton(question.getFirst());
        JButton second = new JButton(question.getSecond());
        JButton third = new JButton(question.getThird());
        text.setBounds(20, 20, width, 100);
        add(text);
        first.setBounds(width / 2 - question.getFirst().length() * 15 / 2, 100, question.getFirst().length() * 15, 50);
        first.addActionListener(new Listener(first));
        add(first);
        second.setBounds(width / 2 - question.getSecond().length() * 15 / 2, 160, question.getSecond().length() * 15, 50);
        second.addActionListener(new Listener(second));
        add(second);
        third.setBounds(width / 2 - question.getThird().length() * 15 / 2, 220, question.getThird().length() * 15, 50);
        third.addActionListener(new Listener(third));
        add(third);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }


    class Listener implements ActionListener {
        private JButton button;

        public Listener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (button.getText().contains("*"))
                numOfRightAnswers++;
            numOfAnswers++;
            if (numOfAnswers == 3) {
                if (numOfRightAnswers == 3)
                    JOptionPane.showMessageDialog(button, "Поздравляем, экзамен сдан", "Попытки кончились", JOptionPane.INFORMATION_MESSAGE, null);
                else
                    JOptionPane.showMessageDialog(button, "Не поздравляем, экзамен не сдан", "Попытки кончились", JOptionPane.INFORMATION_MESSAGE, null);
                System.exit(0);
            }
            dispose();
        }
    }
}