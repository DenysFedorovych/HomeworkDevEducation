package com.bitbucket.painter_balls.utils;

import com.bitbucket.painter_balls.view.Ball;

import java.awt.*;

public class MergingOperator {

    private Ball ball;

    public MergingOperator(Ball one, Ball two) {
        int newDiameter = newDiameter(one.getDiameter(), two.getDiameter());
        double c1 = weightCoefficient(one.getDiameter(), two.getDiameter());
        double c2 = 1 - c1;
        Color newColor = new Color((int) (c1 * one.getColor().getRed() + c2 * two.getColor().getRed()),(int) (c1 * one.getColor().getBlue() + c2 * two.getColor().getBlue()),(int) (c1 * one.getColor().getGreen() + c2 * two.getColor().getGreen()));
        int x = (int) (c1 * one.getX() + c2 * two.getX());
        int y = (int) (c1 * one.getY() + c2 * two.getY());
        int v_x = (int) (c1 * one.getV_x() + c2 * two.getV_x());
        int v_y = (int) (c1 * one.getV_y() + c2 * two.getV_y());
        this.ball = new Ball(x, y, v_x, v_y, newDiameter, newColor);
    }

    private double weightCoefficient(double a, double b) {
        double a_2 = Math.pow(a, 2);
        return a_2 / (a_2 + Math.pow(b, 2));
    }

    private int newDiameter(double a, double b) {
        return (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public Ball getBall() {
        return ball;
    }
}
