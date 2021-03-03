package com.github.simple_paint.swing;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(GraphicPanel panel){
        setTitle("Simple Paint");
        setBounds(200,100,600,600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel);

        setVisible(Boolean.TRUE);
    }
}
