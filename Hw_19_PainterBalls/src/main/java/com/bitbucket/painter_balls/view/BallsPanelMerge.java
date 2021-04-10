package com.bitbucket.painter_balls.view;

import com.bitbucket.painter_balls.utils.MergingOperator;
import com.bitbucket.painter_balls.utils.RandomNumber;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BallsPanelMerge extends JPanel {

    private AtomicInteger counter = new AtomicInteger(0);

    private List<Ball> balls = new ArrayList<>();

    public BallsPanelMerge() {
        this.setLayout(null);
        this.setBounds(20, 20, 760, 760);
        Thread ballsController = new Thread(new BallsController(balls,this));
        ballsController.start();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Ball ball = new Ball(e.getX(), e.getY(), RandomNumber.getRandomDiameter());
                addNewBall(ball);
            }
        });
        this.setVisible(true);
    }

    private void addNewBall(Ball ball){
        balls.add(ball);
        ball.setBorders(BallsPanelMerge.this);
        this.add(ball);
        Thread thread = new Thread(ball, "ball-thread number " + counter.getAndIncrement());
        thread.start();
        this.repaint();
    }

    private void deleteBall(Ball... balls){
        for (Ball ball : balls) {
            this.remove(ball);
            ball.stop();
            this.balls.remove(ball);
        }
    }

    public void mergeBalls(Ball one, Ball two){
        deleteBall(one, two);
        Ball newOne = new MergingOperator(one, two).getBall();
        addNewBall(newOne);
    }


}
