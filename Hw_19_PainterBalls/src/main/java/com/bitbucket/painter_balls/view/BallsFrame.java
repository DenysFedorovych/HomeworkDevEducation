package com.bitbucket.painter_balls.view;

import javax.swing.*;
import java.awt.*;

public class BallsFrame extends JFrame {

    public BallsFrame() throws HeadlessException {
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100,100,800,800);
        this.add(new BallsPanel());
        this.setVisible(true);
    }

}

