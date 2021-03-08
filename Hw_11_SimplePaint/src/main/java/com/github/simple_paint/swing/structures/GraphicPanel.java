package com.github.simple_paint.swing.structures;

import com.github.simple_paint.swing.models.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class GraphicPanel extends JPanel {

    private Rectangle bounds = new Rectangle(0, 0, 600, 600);

    private int x1, y1, x2, y2;

    private int thickness = 1;

    private int color = Color.BLACK.getRGB();

    private Graphics2D graphics;

    public List<Line> getLines() {
        return lines;
    }

    private List<Line> lines = new LinkedList<>();

    public GraphicPanel() {

        setBounds(bounds);
        setBackground(new Color(175, 121, 121));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

        setVisible(true);

    }

    public void clear() {

        this.lines = new LinkedList<>();
        this.setVisible(false);
        this.setVisible(true);

    }

    public void repaintLines(List<Line> lines) {

        for (Line each : lines) {
            this.paintLine(each);
        }

    }

    public void paintLine(Line a) {

        graphics = (Graphics2D) this.getGraphics();
        this.setColor(new Color(a.getColor()));
        this.setThickness(a.getThickness());
        graphics.drawLine(a.getX1(), a.getY1(), a.getX2(), a.getY2());

    }

    public void setColor(Color color) {
        setUpDrawingGraphics();
        graphics.setColor(color);
        this.color = color.getRGB();
    }

    public void setThickness(int thickness) {
        graphics.setStroke(new BasicStroke(thickness));
        this.thickness = thickness;
    }

    private MouseAdapter mouse = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            graphics = (Graphics2D) GraphicPanel.this.getGraphics();

            x1 = e.getX();
            y1 = e.getY();

            x2 = x1;
            y2 = y1;

            graphics.setColor(new Color(GraphicPanel.this.color));
            graphics.setStroke(new BasicStroke(GraphicPanel.this.thickness));
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            x2 = e.getX();
            y2 = e.getY();

            graphics.drawLine(x2, y2, x1, y1);
            Line line = new Line(x1, y1, x2, y2, GraphicPanel.this.color, GraphicPanel.this.thickness);
            GraphicPanel.this.lines.add(line);

            x1 = x2;
            y1 = y2;
        }
    };

    private void setUpDrawingGraphics() {
        graphics = (Graphics2D) getGraphics();
    }


}