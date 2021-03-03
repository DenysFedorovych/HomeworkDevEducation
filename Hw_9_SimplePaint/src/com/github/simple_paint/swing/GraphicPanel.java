package com.github.simple_paint.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicPanel extends JPanel {

    private int x1, y1, x2, y2;

    private Graphics graphics;

    private void setUpDrawingGraphics() {
        graphics = getGraphics();
    }

    private MouseAdapter mouse = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {

            x1 = e.getX();
            y1 = e.getY();

            x2 = x1;
            y2 = y1;

            setUpDrawingGraphics();
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            x2 = e.getX();
            y2 = e.getY();

            graphics.drawLine(x2, y2, x1, y1);

            x1 = x2;
            y1 = y2;

        }
    };

    public GraphicPanel() {

        setSize(600, 600);
        setBackground(new Color(255, 255, 255));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

        JButton colorButton = new JButton("Color");


        setVisible(true);
}
}
