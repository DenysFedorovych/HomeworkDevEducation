package com.bitbucket.painter_balls.view;

import com.bitbucket.painter_balls.utils.RandomNumber;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel implements Runnable {

    private int x;
    private int y;
    private int v_x;
    private int v_y;

    private int rightBorder;
    private int bottomBorder;

    private final int diameter;
    private final Color color;

    public Ball(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = RandomNumber.getRandomColor();
        this.v_x = RandomNumber.getRandomVelocity();
        this.v_y = RandomNumber.getRandomVelocity();
        this.setBounds(x,y,diameter,diameter);
        this.setVisible(true);
        this.setOpaque(false);
    }

    public void setBorders(JPanel parent){
        this.rightBorder = parent.getWidth() - diameter;
        this.bottomBorder = parent.getHeight() - diameter;
    }



    private void move(){
        if(this.x <= 0 || this.x >= rightBorder){
            v_x = -v_x;
        }
        if(this.y <= 0 || this.y >= bottomBorder){
            v_y = -v_y;
        }
        this.x += v_x;
        this.y += v_y;
        setLocation(this.x, this.y);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(this.color);
        graphics2D.fillOval(0,0,diameter,diameter);
    }

    public void run() {
        try {
            while (true) {
                move();
                Thread.sleep(10);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }



}
