package com.github.simple_paint.swing.structures;

import javax.swing.*;
import java.awt.*;

public class FramePaint extends JFrame {
    public FramePaint(GraphicPanel panel, ConfigPanel configPanel){
        setTitle("Simple Paint");
        setBounds(200,100,800,600);
        setBackground(Color.BLACK);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel);
        add(configPanel);

        setVisible(Boolean.TRUE);
    }
}