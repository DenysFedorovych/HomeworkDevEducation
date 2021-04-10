package com.bitbucket.painter_balls.view;

import com.bitbucket.painter_balls.utils.RandomNumber;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel implements Runnable {

    private boolean isStopped = false;

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
        this.setBounds(x, y, diameter, diameter);
        this.setVisible(true);
        this.setOpaque(false);
    }

    public Ball(int x, int y, int v_x, int v_y, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.v_x = v_x;
        this.v_y = v_y;
        this.diameter = diameter;
        this.color = color;
        this.setBounds(x, y, diameter, diameter);
        this.setVisible(true);
        this.setOpaque(false);
    }

    public void run() {
        if (isStopped) {
            Thread.currentThread().interrupt();
        }
        try {
            while (true) {
                move();
                Thread.sleep(15);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private synchronized void move() {
        if (this.x <= 0 || this.x >= rightBorder) {
            v_x = -v_x;
        }
        if (this.y <= 0 || this.y >= bottomBorder) {
            v_y = -v_y;
        }
        this.x += v_x;
        this.y += v_y;
        setLocation(this.x, this.y);
    }

    public int getV_x() {
        return v_x;
    }

    public int getV_y() {
        return v_y;
    }

    public int getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(this.color);
        graphics2D.fillOval(0, 0, diameter, diameter);
    }

    public boolean intersect(Ball another) {
        int delta = (this.diameter - another.diameter)/2;
        double dist = Math.sqrt(Math.pow(this.x - another.x + delta, 2) + Math.pow(this.y - another.y + delta, 2));
        return dist < (this.diameter + another.diameter) / 2;
    }

    public void setBorders(JPanel parent) {
        this.rightBorder = parent.getWidth() - diameter;
        this.bottomBorder = parent.getHeight() - diameter;
    }

    public void stop() {
        this.isStopped = true;
    }


}
