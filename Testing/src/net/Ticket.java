package net;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ticket extends JPanel {
    private int number;
    private Question question = new Question();
    private MouseHandler handler = new MouseHandler();

    public Ticket(int number, int positionX, int positionY) {
        this.number = number;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("Questions.txt"))) {
            for (int i = 0; i < 4 * (number - 1) + 1; i++)
                br.readLine();
            line = br.readLine();
            question.setText(line);
            question.setFirst(br.readLine());
            question.setSecond(br.readLine());
            question.setThird(br.readLine());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        setLayout(new GridBagLayout());
        JLabel label = new JLabel(String.valueOf(number));
        add(label);
        setBounds(positionX, positionY, 40, 70);
        setBackground(Color.WHITE);
        addMouseListener(handler);
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            setVisible(false);
            new QuestionWindow(question);
        }
    }
}