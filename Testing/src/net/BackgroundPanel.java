package net;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BackgroundPanel extends JPanel {
    private List<Integer> numbers = new LinkedList<>();
    private Image backgroundImage;

    public BackgroundPanel(String fileName) throws IOException {
        setLayout(null);
        initList();
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 10; j++)
                add(new Ticket(getRandomNumber(), 100 + 83 * j, 100 + 200 * i));
        backgroundImage = ImageIO.read(new File(fileName));
    }

    private void initList() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);
        numbers.add(16);
        numbers.add(17);
        numbers.add(18);
        numbers.add(19);
        numbers.add(20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }

    private int getRandomNumber() {
        Random random = new Random();
        int index = random.nextInt(numbers.size()) + 1;
        return numbers.remove(index - 1);
    }
}
