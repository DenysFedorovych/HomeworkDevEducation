package com.bitbucket.painter_balls.view;

import com.bitbucket.painter_balls.utils.RandomNumber;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicInteger;

public class BallsPanel extends JPanel {

    private AtomicInteger counter = new AtomicInteger(0);

    public BallsPanel() {
        this.setLayout(null);
        this.setBounds(20, 20, 760, 760);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Ball ball = new Ball(e.getX(), e.getY(), RandomNumber.getRandomDiameter());
                ball.setBorders(BallsPanel.this);
                add(ball);
                Thread thread = new Thread(ball, "ball-thread number " + counter.incrementAndGet());
                thread.start();
            }
        });
        this.setVisible(true);
    }
}
